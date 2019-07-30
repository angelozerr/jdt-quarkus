# jdt-quarkus
POC to generate with JDT all keys of Quarkus available for the application.properties

Here a generated JSON properties from JDT:

For the moment only ConfigRoot & ConfigItem are managed. It misses ConfigGroup (ex : quarkus.http.port is missing because it's a ConfigGRoup).

This JSON is an array of Quarkus [ConfigDescriptionBuildItem](https://github.com/quarkusio/quarkus/blob/master/core/deployment/src/main/java/io/quarkus/deployment/builditem/ConfigDescriptionBuildItem.java):


```json
[
	{
		"propertyName": "quarkus.application.name",
		"type": "java.lang.String"
	},
	{
		"propertyName": "quarkus.application.version",
		"type": "java.lang.String"
	},
	{
		"propertyName": "quarkus.jni.library-paths"
	},
	{
		"propertyName": "quarkus.jni.enable",
		"defaultValue": "false"
	},
	{
		"propertyName": "quarkus.ssl.native"
	},
	{
		"propertyName": "quarkus.index-dependency"
	},
	{
		"propertyName": "quarkus.thread-pool.core-threads",
		"defaultValue": "1"
	},
	{
		"propertyName": "quarkus.thread-pool.max-threads",
		"type": "java.util.OptionalInt"
	},
	{
		"propertyName": "quarkus.thread-pool.queue-size",
		"type": "java.util.OptionalInt"
	},
	{
		"propertyName": "quarkus.thread-pool.growth-resistance",
		"defaultValue": "0"
	},
	{
		"propertyName": "quarkus.thread-pool.shutdown-timeout",
		"type": "java.time.Duration",
		"defaultValue": "1M"
	},
	{
		"propertyName": "quarkus.thread-pool.shutdown-interrupt",
		"type": "java.time.Duration",
		"defaultValue": "10"
	},
	{
		"propertyName": "quarkus.thread-pool.shutdown-check-interval",
		"defaultValue": "5"
	},
	{
		"propertyName": "quarkus.thread-pool.keep-alive-time",
		"type": "java.time.Duration",
		"defaultValue": "30"
	},
	{
		"propertyName": "quarkus.log.category"
	},
	{
		"propertyName": "quarkus.log.filter"
	},
	{
		"propertyName": "quarkus.log.level"
	},
	{
		"propertyName": "quarkus.log.min-level",
		"type": "java.util.logging.Level",
		"defaultValue": "INFO"
	},
	{
		"propertyName": "quarkus.log.console.enable",
		"defaultValue": "true"
	},
	{
		"propertyName": "quarkus.log.console.format",
		"type": "java.lang.String",
		"defaultValue": "%d{yyyy-MM-dd HH:mm:ss,SSS} %-5p [%c{3.}] (%t) %s%e%n"
	},
	{
		"propertyName": "quarkus.log.console.level",
		"type": "java.util.logging.Level",
		"defaultValue": "ALL"
	},
	{
		"propertyName": "quarkus.log.console.color",
		"defaultValue": "true"
	},
	{
		"propertyName": "quarkus.log.console.darken",
		"defaultValue": "0"
	},
	{
		"propertyName": "quarkus.log.console.async"
	},
	{
		"propertyName": "quarkus.log.console.async.queue-length",
		"defaultValue": "512"
	},
	{
		"propertyName": "quarkus.log.console.async.overflow",
		"type": "org.jboss.logmanager.handlers.AsyncHandler$OverflowAction",
		"defaultValue": "BLOCK"
	},
	{
		"propertyName": "quarkus.log.file.default_log_file_name",
		"type": "java.lang.String",
		"defaultValue": "\u003c\u003cno default\u003e\u003e"
	},
	{
		"propertyName": "quarkus.log.file.enable"
	},
	{
		"propertyName": "quarkus.log.file.format",
		"type": "java.lang.String",
		"defaultValue": "%d{yyyy-MM-dd HH:mm:ss,SSS} %h %N[%i] %-5p [%c{3.}] (%t) %s%e%n"
	},
	{
		"propertyName": "quarkus.log.file.level",
		"type": "java.util.logging.Level",
		"defaultValue": "ALL"
	},
	{
		"propertyName": "quarkus.log.file.path",
		"type": "java.io.File",
		"defaultValue": "quarkus.log"
	},
	{
		"propertyName": "quarkus.log.file.async"
	},
	{
		"propertyName": "quarkus.log.file.async.queue-length",
		"defaultValue": "512"
	},
	{
		"propertyName": "quarkus.log.file.async.overflow",
		"type": "org.jboss.logmanager.handlers.AsyncHandler$OverflowAction",
		"defaultValue": "BLOCK"
	},
	{
		"propertyName": "quarkus.log.file.rotation.max-file-size"
	},
	{
		"propertyName": "quarkus.log.file.rotation.max-backup-index",
		"defaultValue": "1"
	},
	{
		"propertyName": "quarkus.log.file.rotation.file-suffix"
	},
	{
		"propertyName": "quarkus.log.file.rotation.rotate-on-boot",
		"defaultValue": "true"
	},
	{
		"propertyName": "quarkus.infinispan-client.near-cache-max-entries",
		"defaultValue": "0"
	},
	{
		"propertyName": "quarkus.infinispan-client.server-list"
	},
	{
		"propertyName": "quarkus.http.cors"
	},
	{
		"propertyName": "quarkus.http.port",
		"defaultValue": "8080"
	},
	{
		"propertyName": "quarkus.http.ssl-port",
		"defaultValue": "8443"
	},
	{
		"propertyName": "quarkus.http.test-port",
		"defaultValue": "8081"
	},
	{
		"propertyName": "quarkus.http.test-ssl-port",
		"defaultValue": "8444"
	},
	{
		"propertyName": "quarkus.http.host",
		"type": "java.lang.String",
		"defaultValue": "0.0.0.0"
	},
	{
		"propertyName": "quarkus.http.io-threads",
		"type": "java.util.OptionalInt"
	},
	{
		"propertyName": "quarkus.http.ssl.certificate.file"
	},
	{
		"propertyName": "quarkus.http.ssl.certificate.key-file"
	},
	{
		"propertyName": "quarkus.http.ssl.certificate.key-store-file"
	},
	{
		"propertyName": "quarkus.http.ssl.certificate.key-store-file-type"
	},
	{
		"propertyName": "quarkus.http.ssl.certificate.key-store-password",
		"type": "java.lang.String",
		"defaultValue": "password"
	},
	{
		"propertyName": "quarkus.http.ssl.cipher-suites"
	},
	{
		"propertyName": "quarkus.http.ssl.protocols",
		"defaultValue": "TLSv1.3,TLSv1.2"
	},
	{
		"propertyName": "quarkus.http.ssl.provider-name"
	},
	{
		"propertyName": "quarkus.http.ssl.session-cache-size",
		"type": "java.util.OptionalInt"
	},
	{
		"propertyName": "quarkus.http.ssl.session-timeout"
	},
	{
		"propertyName": "quarkus.http.cors.origins"
	},
	{
		"propertyName": "quarkus.http.cors.methods"
	},
	{
		"propertyName": "quarkus.http.cors.headers"
	},
	{
		"propertyName": "quarkus.http.cors.exposed-headers"
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
