# jadf.sdk
Java SDK for Autodesk forge developer API

SDK supports below operations
1. Create a bucket
2. Delete a bucket
3. Upload a (RVT) file to a bucket
4. Get manifest
5. Delete manifest
6. Covert to SVF
7. Download SVF bubble

This implementation is done in a modular way and it is split in to below modules/sub-projects
1. API - Contains all interfaces
2. Core - Contains core implementation of AutoDesk Forge API
3. GSON Impl - JSON string handling implementation using Google GSON library
4. REST Impl - REST API handling implementation using JBoss RestEasy.

This project generates multiple artifacts, one for each module/sub-project listed above and also they are OSGI bundles and ready to be used in OSGI environments.

Modular implementation also allows one to opt for different libraries for JSON handling and REST calls.
For example if one wants to use Jackson library for JSON handling instead of Google GSON, they only need to implement only set of interfaces and replace GSON Impl project.
