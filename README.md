# jdt-quarkus
POC to generate with JDT all keys of Quarkus available for the application.properties

Here a generated JSON properties from JDT:

For the moment only ConfigRoot & ConfigItem are managed. It misses ConfigGroup (ex : quarkus.http.port is missing because it's a ConfigGRoup).

This JSON is an array of Quarkus [ConfigDescriptionBuildItem](https://github.com/quarkusio/quarkus/blob/master/core/deployment/src/main/java/io/quarkus/deployment/builditem/ConfigDescriptionBuildItem.java):


```json
[
  {
    "propertyName": "quarkus.application.name"
  },
  {
    "propertyName": "quarkus.application.version"
  },
  {
    "propertyName": "quarkus.jni.library-paths"
  },
  {
    "propertyName": "quarkus.jni.enable"
  },
  {
    "propertyName": "quarkus.ssl.native_"
  },
  {
    "propertyName": "quarkus.index-dependency.index-dependency"
  },
  {
    "propertyName": "quarkus.thread-pool.core-threads"
  },
  {
    "propertyName": "quarkus.thread-pool.max-threads"
  },
  {
    "propertyName": "quarkus.thread-pool.queue-size"
  },
  {
    "propertyName": "quarkus.thread-pool.growth-resistance"
  },
  {
    "propertyName": "quarkus.thread-pool.shutdown-timeout"
  },
  {
    "propertyName": "quarkus.thread-pool.shutdown-interrupt"
  },
  {
    "propertyName": "quarkus.thread-pool.shutdown-check-interval"
  },
  {
    "propertyName": "quarkus.thread-pool.keep-alive-time"
  },
  {
    "propertyName": "quarkus.log.categories"
  },
  {
    "propertyName": "quarkus.log.filters"
  },
  {
    "propertyName": "quarkus.log.level"
  },
  {
    "propertyName": "quarkus.log.min-level"
  },
  {
    "propertyName": "quarkus.log.console",
    "defaultValue": "\u003c\u003cno default\u003e\u003e"
  },
  {
    "propertyName": "quarkus.log.file",
    "defaultValue": "\u003c\u003cno default\u003e\u003e"
  },
  {
    "propertyName": "quarkus.infinispan-client.infinispan-client"
  },
  {
    "propertyName": "quarkus.infinispan-client.infinispan-client"
  },
  {
    "propertyName": "quarkus.http.http"
  },
  {
    "propertyName": "quarkus.http.port"
  },
  {
    "propertyName": "quarkus.http.ssl-port"
  },
  {
    "propertyName": "quarkus.http.test-port"
  },
  {
    "propertyName": "quarkus.http.test-ssl-port"
  },
  {
    "propertyName": "quarkus.http.host"
  },
  {
    "propertyName": "quarkus.http.io-threads"
  },
  {
    "propertyName": "quarkus.http.ssl",
    "defaultValue": "\u003c\u003cno default\u003e\u003e"
  },
  {
    "propertyName": "quarkus.http.cors",
    "defaultValue": "\u003c\u003cno default\u003e\u003e"
  }
]
```

# TODO

 - manage ConfigGroup
 - manage type
 - manage enum?
 - manage required property
 - manage docs
 - manage isQuarkusProject
 - manage location (easy with JDT)

# Other...

https://github.com/quarkusio/quarkus/pull/3032/files

 * https://quarkus.io/guides/application-configuration-guide
 * https://quarkus.io/guides/extension-authors-guide#configuration
 
 Required property -> https://quarkus.io/guides/application-configuration-guide#injecting-configuration-value
 
https://github.com/quarkusio/quarkus/blob/master/extensions/undertow/runtime/src/main/java/io/quarkus/undertow/runtime/HttpConfig.java
