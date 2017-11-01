package in.rakesh.autodesk.client.derivative.bubble;

import in.rakesh.autodesk.client.derivative.*;
import in.rakesh.autodesk.client.io.*;
import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.model.*;
import in.rakesh.autodesk.model.bubble.*;
import in.rakesh.autodesk.model.bubble.impl.*;
import in.rakesh.autodesk.model.manifest.*;
import in.rakesh.autodesk.model.manifest.impl.*;

import org.slf4j.*;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import java.util.zip.*;

/**
 * AdfBubbleContext
 */
public class AdfBubbleContext
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final Logger LOG = LoggerFactory.getLogger(AdfBubbleContext.class);

  private static final List<String> DERIVATIVE_ROLES = new ArrayList<>();

  static
  {
    DERIVATIVE_ROLES.add("Autodesk.CloudPlatform.DesignDescription");
    DERIVATIVE_ROLES.add("Autodesk.CloudPlatform.PropertyDatabase");
    DERIVATIVE_ROLES.add("Autodesk.CloudPlatform.IndexableContent");
    DERIVATIVE_ROLES.add("leaflet-zip");
    DERIVATIVE_ROLES.add("thumbnail");
    DERIVATIVE_ROLES.add("graphics");
    DERIVATIVE_ROLES.add("preview");
    DERIVATIVE_ROLES.add("raas");
    DERIVATIVE_ROLES.add("pdf");
    DERIVATIVE_ROLES.add("lod");
  }

  //~ Instance Variables ---------------------------------------------------------------------------

  private final ExecutorService executorService;

  private final IAdfDerivativesClient derivativesClient;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfBubbleDownloadContext object.
   *
   * @param aDerivativesClient DOCUMENT ME!
   */
  public AdfBubbleContext(IAdfDerivativesClient aDerivativesClient)
  {
    this.derivativesClient = aDerivativesClient;
    this.executorService = Executors.newCachedThreadPool();
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to download AutoDesk forge bubble identified by given URN, and save it to the given
   * directory.
   *
   * @param  aUrn   manifest URN
   * @param  aToDir directory name where downloaded bubble need to saved to
   *
   * @return
   *
   * @throws AdfRestException
   */
  public CompletableFuture<List<IAdfFileDownloadStatus>> download(String aUrn, String aToDir) throws AdfRestException
  {
    if (LOG.isDebugEnabled())
    {
      LOG.debug("Downloading manifest for URN - " + aUrn);
    }
    IAdfBubbleNode manifest = this.derivativesClient.getBubbleManifest(aUrn);

    return this.download(aUrn, manifest, aToDir);
  }


  /**
   * method to download AutoDesk forge bubble identified by given URN, and save it to the given
   * directory.
   *
   * @param  aUrn      manifest URN
   * @param  aManifest manifest retrieved previously, to be used to download bubble
   * @param  aToDir    directory name where downloaded bubble need to saved to
   *
   * @return
   */
  public CompletableFuture<List<IAdfFileDownloadStatus>> download(String aUrn, IAdfBubbleNode aManifest, String aToDir)
  {
    if (LOG.isDebugEnabled())
    {
      LOG.debug("Parsing manifest and listing all derivative files for manifest urn - " + aUrn);
    }

    List<IAdfDerivativeItem> derivatives = listDerivatives(aManifest.getChildren(), aManifest.getUrn());

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Derivative files listing complete. Manifests to process is - '" + derivatives.size() + "'.");
    }

    CompletableFuture<List<IAdfDerivativeItem>> derivativesFuture = processDerivatives(derivatives);
    return derivativesFuture.thenCompose((List<IAdfDerivativeItem> aDerivativeItems) ->
      {
        List<IAdfDownloadItem> filesToDownload = aDerivativeItems.stream() //
        .flatMap(aItem -> aItem.getFiles().stream()) //
        .collect(Collectors.toList());

        if (LOG.isDebugEnabled())
        {
          LOG.debug("Total number of derivative files to download - " + filesToDownload.size());
        }

        List<CompletableFuture<IAdfFileDownloadStatus>> downloadFutures = filesToDownload.stream() //
        .map(aFile -> downloadDerivativeItem(aFile, aToDir)) //
        .collect(Collectors.toList());

        return allOf(downloadFutures);
      });
  }


  /**
   * method to decode given uri
   *
   * @param  aValue encoded uri
   *
   * @return String decoded uri
   *
   * @throws IllegalArgumentException
   */
  private static String decode(String aValue)
  {
    try
    {
      return URLDecoder.decode(aValue, StandardCharsets.UTF_8.name());
    }
    catch (UnsupportedEncodingException e)
    {
      throw new IllegalArgumentException("Error while decoding URI.", e);
    }
  }


  /**
   * method to encode given uri, so that it is URL safe
   *
   * @param  aValue uri string
   *
   * @return String encoded uri
   *
   * @throws IllegalArgumentException
   */
  private static String encode(String aValue)
  {
    try
    {
      return URLEncoder.encode(aValue, StandardCharsets.UTF_8.name());
    }
    catch (UnsupportedEncodingException e)
    {
      throw new IllegalArgumentException("Error while encoding URI.", e);
    }
  }


  /**
   * method to parse given derivative URN and extract path information, which can later be used to
   * download files.
   *
   * @param  aUrn derivative URN
   *
   * @return AdfDerivativeItem
   */
  private static AdfDerivativeItem extractPathFromUrn(String aUrn)
  {
    String decodedUrn = decode(aUrn);

    String rootFileName = decodedUrn.substring(decodedUrn.lastIndexOf('/') + 1);
    String basePath = decodedUrn.substring(0, decodedUrn.lastIndexOf('/') + 1);
    String localPathTmp = basePath.substring(basePath.indexOf('/') + 1);
    String localPath = localPathTmp.replaceAll("^output\\/", "");

    AdfDerivativeItem entry = new AdfDerivativeItem();
    entry.setUrn(decodedUrn);
    entry.setBasePath(basePath);
    entry.setLocalPath(localPath);
    entry.setRootFileName(rootFileName);
    return entry;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aFuturesList DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  @SuppressWarnings("unchecked")
  private final <T> CompletableFuture<List<T>> allOf(List<CompletableFuture<T>> aFuturesList)
  {
    CompletableFuture<Status>[] futuresArray = aFuturesList.toArray(new CompletableFuture[aFuturesList.size()]);
    return CompletableFuture.allOf(futuresArray) //
                            .thenApply(aVoid -> aFuturesList.stream() //
                                .map(aFuture -> aFuture.join()) //
                                .collect(Collectors.<T>toList()) //
                                );
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aDerivative DOCUMENT ME!
   * @param  aUrn        DOCUMENT ME!
   *
   * @return
   */
  private AdfDerivativeItem createF2dDerivativeItem(IAdfBubbleNode aDerivative, String aUrn)
  {
    if (!"geometry".equals(aDerivative.getType().toString()) || (aDerivative.getIntermediateFile() == null) || aDerivative.getChildren().isEmpty())
    {
      return null;
    }
    IAdfBubbleNode f2dItem = null;
    for (IAdfBubbleNode item : aDerivative.getChildren())
    {
      if ("application/autodesk-f2d".equals(item.getMime()))
      {
        f2dItem = item;
        break;
      }
    }

    if (f2dItem == null)
    {
      return null;
    }

    String f2dUrl = f2dItem.getUrn();
    int index = f2dUrl.indexOf(aUrn);
    String baseUrl = f2dUrl.substring(0, index + aUrn.length());

    // Construct the full urn path, similar to how it's stored for the SVF geometry items
    String intermediatePath = '/' + aDerivative.getIntermediateFile();
    if (baseUrl.indexOf("urn:adsk.objects") == 0)
    {
      intermediatePath = encode(intermediatePath);
    }

    String fullPath = baseUrl + intermediatePath;
    AdfDerivativeItem item = extractPathFromUrn(fullPath);
    item.setMime("application/octet-stream");
    item.setUrn(aUrn);
    item.setGuid(aDerivative.getGuid());

    return item;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aDerivative DOCUMENT ME!
   * @param  aParent     DOCUMENT ME!
   * @param  aItem       DOCUMENT ME!
   * @param  aUrn
   *
   * @return
   */
  private AdfDerivativeItem createThumbnailItem(IAdfBubbleNode aDerivative, IAdfBubbleNode aParent, AdfDerivativeItem aItem, String aUrn)
  {
    if (aParent == null)
    {
      return null;
    }

    String mime = aDerivative.getMime();
    if (("application/autodesk-svf".equals(mime) || "application/autodesk-f2d".equals(mime)) && aParent.hasThumbnail())
    {
      AdfDerivativeItem entry = new AdfDerivativeItem();
      entry.setUrn(aUrn);
      entry.setLocalPath(aItem.getLocalPath());
      entry.setRootFileName(aItem.getRootFileName() + ".png");
      entry.setGuid(aParent.getGuid());
      entry.setMime("thumbnail");
      // TODO: Check base path
      String basePath = aUrn.substring(0, aUrn.lastIndexOf('/') + 1);
      entry.setBasePath(basePath);
      // entry.setThumbnailUrn("$file$/thumbnails/" + aParent.getGuid() + ".png");

      return entry;
    }
    return null;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aFile DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws AdfRestException
   */
  private InputStream doDownload(IAdfDownloadItem aFile) throws AdfRestException
  {
    if (aFile.isThumbnail())
    {
      AdfThumbnailDownloadItem item = (AdfThumbnailDownloadItem) aFile;
      return this.derivativesClient.downloadThumbnail(item.getDerivativeUrn(), item.getGuid());
    }
    return this.derivativesClient.downloadDerivative(aFile.getFileUrn());
  }


  /**
   * DOCUMENT ME!
   *
   * @param aFile
   * @param aToDir
   * @param aFuture
   */
  private void doDownloadDerivativeItem(IAdfDownloadItem aFile, String aToDir, CompletableFuture<IAdfFileDownloadStatus> aFuture)
  {
    if (LOG.isTraceEnabled())
    {
      LOG.trace("Downloading file '" + aFile.getLocalPath() + "'.");
    }

    try(InputStream stream = this.doDownload(aFile))
    {
      IFileSystem fileSystem = this.derivativesClient.getFileSystem();

      IFileData fileData = fileSystem.createFileData(aToDir, aFile.getLocalPath());
      fileSystem.put(stream, fileData);

      aFuture.complete(new AdfFileDownloadStatus(aFile.getFileUrn(), Status.SUCCESS));
    }
    catch (Throwable e) // NOSONAR
    {
      if (LOG.isErrorEnabled())
      {
        LOG.error("Error while downloading file '" + aFile.getLocalPath() + "'.", e);
      }
      aFuture.complete(new AdfFileDownloadStatus(aFile.getFileUrn(), Status.FAILED));
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aFile  DOCUMENT ME!
   * @param  aToDir DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  private CompletableFuture<IAdfFileDownloadStatus> downloadDerivativeItem(IAdfDownloadItem aFile, String aToDir)
  {
    CompletableFuture<IAdfFileDownloadStatus> future = new CompletableFuture<>();
    this.executorService.submit(() -> doDownloadDerivativeItem(aFile, aToDir, future));
    return future;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aDerivatives DOCUMENT ME!
   * @param  aUrn
   *
   * @return DOCUMENT ME!
   */
  private List<IAdfDerivativeItem> listDerivatives(List<IAdfBubbleNode> aDerivatives, String aUrn)
  {
    List<IAdfDerivativeItem> derivativeItems = new ArrayList<>();
    for (IAdfBubbleNode derivative : aDerivatives)
    {
      List<IAdfDerivativeItem> children = listDerivatives(derivative.getChildren(), derivative, aUrn);
      if (children.isEmpty())
      {
        continue;
      }
      derivativeItems.addAll(children);
    }
    return derivativeItems;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aDerivatives DOCUMENT ME!
   * @param  aParent      DOCUMENT ME!
   * @param  aUrn
   *
   * @return
   */
  private List<IAdfDerivativeItem> listDerivatives(List<IAdfBubbleNode> aDerivatives, IAdfBubbleNode aParent, String aUrn)
  {
    if (aDerivatives.isEmpty())
    {
      return Collections.emptyList();
    }

    List<IAdfDerivativeItem> derivatives = new ArrayList<>();
    for (IAdfBubbleNode derivative : aDerivatives)
    {
      List<IAdfDerivativeItem> derivativeItems = traverse(derivative, aParent, aUrn);
      if (!derivativeItems.isEmpty())
      {
        derivatives.addAll(derivativeItems);
      }
    }
    return derivatives;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aItem DOCUMENT ME!
   *
   * @return
   */
  private CompletableFuture<IAdfDerivativeItem> parseF2DDerivates(IAdfDerivativeItem aItem)
  {
    CompletableFuture<IAdfDerivativeItem> future = new CompletableFuture<>();

    this.executorService.submit(() ->
    {
      if (LOG.isTraceEnabled())
      {
        LOG.trace("Parsing F2d derivative item - " + aItem.getGuid() + " and its assets.");
      }

      aItem.addFileName("manifest.json.gz");
      String manifestPath = aItem.getBasePath() + "manifest.json.gz";
      try
      {
        this.processF2DDerivativeAssets(manifestPath, aItem, future);
      }
      catch (Throwable e) // NOSONAR
      {
        if (LOG.isErrorEnabled())
        {
          LOG.error("Error while processing f2d derivatives for item GUID '" + aItem.getGuid() + "'.", e);
        }
      }
    });

    return future;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aItem DOCUMENT ME!
   *
   * @return
   */
  private CompletableFuture<IAdfDerivativeItem> parseSVFDerivates(IAdfDerivativeItem aItem)
  {
    CompletableFuture<IAdfDerivativeItem> future = new CompletableFuture<>();

    this.executorService.submit(() ->
    {
      String svfPath = aItem.getUrn().substring(aItem.getBasePath().length());
      aItem.addFileName(svfPath);

      if (LOG.isTraceEnabled())
      {
        LOG.trace("Parsing SVF derivative item - " + svfPath + " and its assets.");
      }
      try
      {
        processSVFDerivativeAssets(aItem.getUrn(), aItem, future);
      }
      catch (Throwable e) // NOSONAR
      {
        if (LOG.isErrorEnabled())
        {
          LOG.error("Error while processing SVF derivatives for item GUID '" + aItem.getGuid() + "'.", e);
        }
      }
    });

    return future;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aDerivative DOCUMENT ME!
   *
   * @return
   */
  private CompletableFuture<IAdfDerivativeItem> processDerivative(IAdfDerivativeItem aDerivative)
  {
    if (LOG.isTraceEnabled())
    {
      LOG.trace("Processing derivative '" + aDerivative.getRootFileName() + "'.");
    }

    switch (aDerivative.getMime())
    {
      case "application/autodesk-svf" :
        return parseSVFDerivates(aDerivative);

      case "application/autodesk-f2d" :
        return parseF2DDerivates(aDerivative);

      case "application/autodesk-db" : // NOSONAR
        aDerivative.addFileName("objects_attrs.json.gz");
        aDerivative.addFileName("objects_vals.json.gz");
        aDerivative.addFileName("objects_offs.json.gz");
        aDerivative.addFileName("objects_ids.json.gz");
        aDerivative.addFileName("objects_avs.json.gz");
        aDerivative.addFileName("objects_viewables.json.gz");
        aDerivative.addFileName("objects_rcv_offs.json.gz");
        aDerivative.addFileName("objects_rcvs.json.gz");

        aDerivative.addFileName(aDerivative.getRootFileName());
        return CompletableFuture.completedFuture(aDerivative);
      default :
        aDerivative.addFileName(aDerivative.getRootFileName());
        return CompletableFuture.completedFuture(aDerivative);
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @param aReader
   * @param aItem
   */
  private void processDerivativeAssets(Reader aReader, IAdfDerivativeItem aItem)
  {
    IAdfDerivativeManifest manifest = this.derivativesClient.getJsonSerializer().fromJson(aReader, AdfDerivativeManifest.class);

    List<IAdfDerivativeAsset> assets = manifest.getAssets();
    for (IAdfDerivativeAsset asset : assets)
    {
      String assetUri = asset.getUri();
      // Skip SVF embedded resources
      if ((assetUri.indexOf("embed:/") == -1) && (assetUri.indexOf("../") == -1))
      {
        if (LOG.isTraceEnabled())
        {
          LOG.trace("Adding derivative asset - " + assetUri);
        }

        aItem.addFileName(assetUri);
      }
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aDerivatives DOCUMENT ME!
   *
   * @return
   */
  private CompletableFuture<List<IAdfDerivativeItem>> processDerivatives(List<IAdfDerivativeItem> aDerivatives)
  {
    List<CompletableFuture<IAdfDerivativeItem>> futuresList = new ArrayList<>();
    for (IAdfDerivativeItem item : aDerivatives)
    {
      futuresList.add(processDerivative(item));
    }

    return allOf(futuresList);
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aUrn    DOCUMENT ME!
   * @param  aItem   aUrn DOCUMENT ME!
   * @param  aFuture DOCUMENT ME!
   *
   * @throws AdfRestException
   * @throws IOException
   */
  private void processF2DDerivativeAssets(String aUrn, IAdfDerivativeItem aItem, CompletableFuture<IAdfDerivativeItem> aFuture) throws AdfRestException, IOException
  {
    try(InputStream stream = new GZIPInputStream(this.derivativesClient.downloadDerivative(aUrn)))
    {
      try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8.name())))
      {
        processDerivativeAssets(reader, aItem);
      }
    }
    finally
    {
      aFuture.complete(aItem);
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aUrn    DOCUMENT ME!
   * @param  aItem   aUrn DOCUMENT ME!
   * @param  aFuture DOCUMENT ME!
   *
   * @throws AdfRestException
   * @throws IOException
   */
  private void processSVFDerivativeAssets(String aUrn, IAdfDerivativeItem aItem, CompletableFuture<IAdfDerivativeItem> aFuture) throws AdfRestException, IOException
  {
    try
    {
      Path tempZipFilePath = Paths.get(aItem.getGuid() + ".zip");

      try(InputStream inStream = this.derivativesClient.downloadDerivative(aUrn))
      {
        // TODO save it to temp directory
        Files.copy(inStream, tempZipFilePath, StandardCopyOption.REPLACE_EXISTING);
      }

      try(ZipFile zipFile = new ZipFile(tempZipFilePath.toFile()))
      {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements())
        {
          ZipEntry entry = entries.nextElement();
          if (!"manifest.json".equals(entry.getName()))
          {
            continue;
          }

          try(Reader reader = new InputStreamReader(zipFile.getInputStream(entry)))
          {
            processDerivativeAssets(reader, aItem);
          }
          break;
        }
      }
    }
    finally
    {
      aFuture.complete(aItem);
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aDerivative DOCUMENT ME!
   * @param  aParent     DOCUMENT ME!
   * @param  aUrn
   *
   * @return
   */
  private List<IAdfDerivativeItem> traverse(IAdfBubbleNode aDerivative, IAdfBubbleNode aParent, String aUrn)
  {
    List<IAdfDerivativeItem> derivatives = new ArrayList<>();

    ViewType role = aDerivative.getRole();
    if ((role != null) && DERIVATIVE_ROLES.contains(role.toString()))
    {
      AdfDerivativeItem item = extractPathFromUrn(aDerivative.getUrn());
      item.setGuid(aDerivative.getGuid());
      item.setMime(aDerivative.getMime());

      derivatives.add(item);

      AdfDerivativeItem thumbnailItem = createThumbnailItem(aDerivative, aParent, item, aUrn);
      if (thumbnailItem != null)
      {
        derivatives.add(thumbnailItem);
      }
    }
    AdfDerivativeItem f2dDerivativeItem = createF2dDerivativeItem(aDerivative, aUrn);
    if (f2dDerivativeItem != null)
    {
      derivatives.add(f2dDerivativeItem);
    }

    List<IAdfDerivativeItem> derivativeItems = listDerivatives(aDerivative.getChildren(), aDerivative, aUrn);
    if (!derivativeItems.isEmpty())
    {
      derivatives.addAll(derivativeItems);
    }

    return derivatives;
  }
}
