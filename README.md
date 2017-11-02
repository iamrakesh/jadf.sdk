
##jadf.sdk

Modular Java sdk implementation for Autodesk Forge developer API

Implementation is split in to below modules/sub-projects
1. **jadf.sdk.api** - Contains all interfaces
2. **jadf.sdk.core** - Contains core implementation of AutoDesk Forge API
3. **jadf.sdk.gson.impl** - JSON string handling implementation using Google GSON library
4. **jadf.sdk.resteasy.impl** - REST API handling implementation using JBoss RestEasy.

This project generates multiple artifacts, one for each module/sub-project listed above and also they are OSGI bundles and ready to be used in OSGI environments.

Modular implementation also allows one to opt for different libraries for JSON handling and REST calls.
For example if one wants to use Jackson library for JSON handling instead of Google GSON, they need to implement only set of interfaces and replace **jadf.sdk.gson.impl** project artifact.

Default implementation supports file I/O to local file system, but this can also be extended like JSON handling implementation, by implementation few interfaces related to I/O.

### Supported API
SDK supports below operations
1. Create a bucket
2. Delete a bucket
3. Upload a (RVT) file to a bucket
4. Get manifest
5. Delete manifest
6. Covert to SVF
7. Download SVF bubble


### How to use
```java
// read or load configuration either by loading from a properites file or creating it manually
Map<String, String> configMap = <read/load configuration>;
IAdfConfig config = new AdfConfig(configMap);

// create context using factory method
IAdfContext context = AdfContext.create(config);

// once context is created use its public method to make Forge API calls
IAdfBucket bucketInfo = context.createBucket(<IAdfBaseBucket>, "US" /*region*/);
// OR
IAdfManifest manifest = context.getManifest("<URN>");

```
Simple isnt it, configuration which is needed to create IAdfContext must contain below values

| Key | Is Mandatory | Default value | Description |
| ------------ | ------------ | ------------ |------------ |
| autodesk.api.base.url | Yes | https://developer.api.autodesk.com/ | Base URL of AutoDesk API |
| autodesk.client.id | Yes | None | Client ID to be used for authentication |
| autodesk.client.sceret | Yes | None | Client secret to be used for authentication |
| autodesk.client.scopes | Yes | None | Scopes to be used for authentication |
| root.folder | Yes | None | Root directory to download files to |


###License

jadf.sdk is licensed under the terms of the MIT License. See the LICENSE file for details.
