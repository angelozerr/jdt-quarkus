# jdt-quarkus
POC to generate with JDT all keys of Quarkus available for the application.properties

Here a generated JSON properties from JDT:

For the moment only ConfigRoot & ConfigItem are managed. It misses ConfigGroup (ex : quarkus.http.port is missing because it's a ConfigGRoup).

This JSON is an array of Quarkus [ConfigDescriptionBuildItem](https://github.com/quarkusio/quarkus/blob/master/core/deployment/src/main/java/io/quarkus/deployment/builditem/ConfigDescriptionBuildItem.java):


```json
[
	{
		"propertyName": "quarkus.application.name",
		"type": "java.lang.String",
		"source": "io.quarkus.deployment.ApplicationConfig#name"
	},
	{
		"propertyName": "quarkus.application.version",
		"type": "java.lang.String",
		"source": "io.quarkus.deployment.ApplicationConfig#version"
	},
	{
		"propertyName": "quarkus.jni.library-paths",
		"source": "io.quarkus.deployment.JniProcessor$JniConfig#libraryPaths"
	},
	{
		"propertyName": "quarkus.jni.enable",
		"defaultValue": "false",
		"source": "io.quarkus.deployment.JniProcessor$JniConfig#enable"
	},
	{
		"propertyName": "quarkus.ssl.native",
		"source": "io.quarkus.deployment.SslProcessor$SslConfig#native_"
	},
	{
		"propertyName": "quarkus.index-dependency",
		"source": "io.quarkus.deployment.index.ApplicationArchiveBuildStep$IndexDependencyConfiguration#indexDependency"
	},
	{
		"propertyName": "quarkus.thread-pool.core-threads",
		"defaultValue": "1",
		"source": "io.quarkus.runtime.ThreadPoolConfig#coreThreads"
	},
	{
		"propertyName": "quarkus.thread-pool.max-threads",
		"type": "java.util.OptionalInt",
		"source": "io.quarkus.runtime.ThreadPoolConfig#maxThreads"
	},
	{
		"propertyName": "quarkus.thread-pool.queue-size",
		"type": "java.util.OptionalInt",
		"source": "io.quarkus.runtime.ThreadPoolConfig#queueSize"
	},
	{
		"propertyName": "quarkus.thread-pool.growth-resistance",
		"defaultValue": "0",
		"source": "io.quarkus.runtime.ThreadPoolConfig#growthResistance"
	},
	{
		"propertyName": "quarkus.thread-pool.shutdown-timeout",
		"type": "java.time.Duration",
		"defaultValue": "1M",
		"source": "io.quarkus.runtime.ThreadPoolConfig#shutdownTimeout"
	},
	{
		"propertyName": "quarkus.thread-pool.shutdown-interrupt",
		"type": "java.time.Duration",
		"defaultValue": "10",
		"source": "io.quarkus.runtime.ThreadPoolConfig#shutdownInterrupt"
	},
	{
		"propertyName": "quarkus.thread-pool.shutdown-check-interval",
		"defaultValue": "5",
		"source": "io.quarkus.runtime.ThreadPoolConfig#shutdownCheckInterval"
	},
	{
		"propertyName": "quarkus.thread-pool.keep-alive-time",
		"type": "java.time.Duration",
		"defaultValue": "30",
		"source": "io.quarkus.runtime.ThreadPoolConfig#keepAliveTime"
	},
	{
		"propertyName": "quarkus.log.category",
		"source": "io.quarkus.runtime.logging.LogConfig#categories"
	},
	{
		"propertyName": "quarkus.log.filter",
		"source": "io.quarkus.runtime.logging.LogConfig#filters"
	},
	{
		"propertyName": "quarkus.log.level",
		"source": "io.quarkus.runtime.logging.LogConfig#level"
	},
	{
		"propertyName": "quarkus.log.min-level",
		"type": "java.util.logging.Level",
		"defaultValue": "INFO",
		"source": "io.quarkus.runtime.logging.LogConfig#minLevel"
	},
	{
		"propertyName": "quarkus.log.console.enable",
		"defaultValue": "true",
		"source": "io.quarkus.runtime.logging.ConsoleConfig#enable"
	},
	{
		"propertyName": "quarkus.log.console.format",
		"type": "java.lang.String",
		"defaultValue": "%d{yyyy-MM-dd HH:mm:ss,SSS} %-5p [%c{3.}] (%t) %s%e%n",
		"source": "io.quarkus.runtime.logging.ConsoleConfig#format"
	},
	{
		"propertyName": "quarkus.log.console.level",
		"type": "java.util.logging.Level",
		"defaultValue": "ALL",
		"source": "io.quarkus.runtime.logging.ConsoleConfig#level"
	},
	{
		"propertyName": "quarkus.log.console.color",
		"defaultValue": "true",
		"source": "io.quarkus.runtime.logging.ConsoleConfig#color"
	},
	{
		"propertyName": "quarkus.log.console.darken",
		"defaultValue": "0",
		"source": "io.quarkus.runtime.logging.ConsoleConfig#darken"
	},
	{
		"propertyName": "quarkus.log.console.async",
		"source": "io.quarkus.runtime.logging.AsyncConfig#enable"
	},
	{
		"propertyName": "quarkus.log.console.async.queue-length",
		"defaultValue": "512",
		"source": "io.quarkus.runtime.logging.AsyncConfig#queueLength"
	},
	{
		"propertyName": "quarkus.log.console.async.overflow",
		"type": "org.jboss.logmanager.handlers.AsyncHandler$OverflowAction",
		"defaultValue": "BLOCK",
		"source": "io.quarkus.runtime.logging.AsyncConfig#overflow"
	},
	{
		"propertyName": "quarkus.log.file.default_log_file_name",
		"type": "java.lang.String",
		"defaultValue": "\u003c\u003cno default\u003e\u003e",
		"source": "io.quarkus.runtime.logging.FileConfig#DEFAULT_LOG_FILE_NAME"
	},
	{
		"propertyName": "quarkus.log.file.enable",
		"source": "io.quarkus.runtime.logging.FileConfig#enable"
	},
	{
		"propertyName": "quarkus.log.file.format",
		"type": "java.lang.String",
		"defaultValue": "%d{yyyy-MM-dd HH:mm:ss,SSS} %h %N[%i] %-5p [%c{3.}] (%t) %s%e%n",
		"source": "io.quarkus.runtime.logging.FileConfig#format"
	},
	{
		"propertyName": "quarkus.log.file.level",
		"type": "java.util.logging.Level",
		"defaultValue": "ALL",
		"source": "io.quarkus.runtime.logging.FileConfig#level"
	},
	{
		"propertyName": "quarkus.log.file.path",
		"type": "java.io.File",
		"defaultValue": "quarkus.log",
		"source": "io.quarkus.runtime.logging.FileConfig#path"
	},
	{
		"propertyName": "quarkus.log.file.async",
		"source": "io.quarkus.runtime.logging.AsyncConfig#enable"
	},
	{
		"propertyName": "quarkus.log.file.async.queue-length",
		"defaultValue": "512",
		"source": "io.quarkus.runtime.logging.AsyncConfig#queueLength"
	},
	{
		"propertyName": "quarkus.log.file.async.overflow",
		"type": "org.jboss.logmanager.handlers.AsyncHandler$OverflowAction",
		"defaultValue": "BLOCK",
		"source": "io.quarkus.runtime.logging.AsyncConfig#overflow"
	},
	{
		"propertyName": "quarkus.log.file.rotation.max-file-size",
		"source": "io.quarkus.runtime.logging.FileConfig$RotationConfig#maxFileSize"
	},
	{
		"propertyName": "quarkus.log.file.rotation.max-backup-index",
		"defaultValue": "1",
		"source": "io.quarkus.runtime.logging.FileConfig$RotationConfig#maxBackupIndex"
	},
	{
		"propertyName": "quarkus.log.file.rotation.file-suffix",
		"source": "io.quarkus.runtime.logging.FileConfig$RotationConfig#fileSuffix"
	},
	{
		"propertyName": "quarkus.log.file.rotation.rotate-on-boot",
		"defaultValue": "true",
		"source": "io.quarkus.runtime.logging.FileConfig$RotationConfig#rotateOnBoot"
	},
	{
		"propertyName": "quarkus.infinispan-client.near-cache-max-entries",
		"defaultValue": "0",
		"source": "io.quarkus.infinispan.client.runtime.InfinispanClientBuildTimeConfig#nearCacheMaxEntries"
	},
	{
		"propertyName": "quarkus.infinispan-client.server-list",
		"source": "io.quarkus.infinispan.client.runtime.InfinispanClientRuntimeConfig#serverList"
	},
	{
		"propertyName": "quarkus.http.cors",
		"source": "io.quarkus.undertow.runtime.HttpBuildConfig#corsEnabled"
	},
	{
		"propertyName": "quarkus.http.port",
		"defaultValue": "8080",
		"source": "io.quarkus.undertow.runtime.HttpConfig#port"
	},
	{
		"propertyName": "quarkus.http.ssl-port",
		"defaultValue": "8443",
		"source": "io.quarkus.undertow.runtime.HttpConfig#sslPort"
	},
	{
		"propertyName": "quarkus.http.test-port",
		"defaultValue": "8081",
		"source": "io.quarkus.undertow.runtime.HttpConfig#testPort"
	},
	{
		"propertyName": "quarkus.http.test-ssl-port",
		"defaultValue": "8444",
		"source": "io.quarkus.undertow.runtime.HttpConfig#testSslPort"
	},
	{
		"propertyName": "quarkus.http.host",
		"type": "java.lang.String",
		"defaultValue": "0.0.0.0",
		"source": "io.quarkus.undertow.runtime.HttpConfig#host"
	},
	{
		"propertyName": "quarkus.http.io-threads",
		"type": "java.util.OptionalInt",
		"source": "io.quarkus.undertow.runtime.HttpConfig#ioThreads"
	},
	{
		"propertyName": "quarkus.http.ssl.certificate.file",
		"source": "io.quarkus.runtime.configuration.ssl.CertificateConfig#file"
	},
	{
		"propertyName": "quarkus.http.ssl.certificate.key-file",
		"source": "io.quarkus.runtime.configuration.ssl.CertificateConfig#keyFile"
	},
	{
		"propertyName": "quarkus.http.ssl.certificate.key-store-file",
		"source": "io.quarkus.runtime.configuration.ssl.CertificateConfig#keyStoreFile"
	},
	{
		"propertyName": "quarkus.http.ssl.certificate.key-store-file-type",
		"source": "io.quarkus.runtime.configuration.ssl.CertificateConfig#keyStoreFileType"
	},
	{
		"propertyName": "quarkus.http.ssl.certificate.key-store-password",
		"type": "java.lang.String",
		"defaultValue": "password",
		"source": "io.quarkus.runtime.configuration.ssl.CertificateConfig#keyStorePassword"
	},
	{
		"propertyName": "quarkus.http.ssl.cipher-suites",
		"source": "io.quarkus.runtime.configuration.ssl.ServerSslConfig#cipherSuites"
	},
	{
		"propertyName": "quarkus.http.ssl.protocols",
		"defaultValue": "TLSv1.3,TLSv1.2",
		"source": "io.quarkus.runtime.configuration.ssl.ServerSslConfig#protocols"
	},
	{
		"propertyName": "quarkus.http.ssl.provider-name",
		"source": "io.quarkus.runtime.configuration.ssl.ServerSslConfig#providerName"
	},
	{
		"propertyName": "quarkus.http.ssl.session-cache-size",
		"type": "java.util.OptionalInt",
		"source": "io.quarkus.runtime.configuration.ssl.ServerSslConfig#sessionCacheSize"
	},
	{
		"propertyName": "quarkus.http.ssl.session-timeout",
		"source": "io.quarkus.runtime.configuration.ssl.ServerSslConfig#sessionTimeout"
	},
	{
		"propertyName": "quarkus.http.cors.origins",
		"source": "io.quarkus.undertow.runtime.filters.CORSConfig#origins"
	},
	{
		"propertyName": "quarkus.http.cors.methods",
		"source": "io.quarkus.undertow.runtime.filters.CORSConfig#methods"
	},
	{
		"propertyName": "quarkus.http.cors.headers",
		"source": "io.quarkus.undertow.runtime.filters.CORSConfig#headers"
	},
	{
		"propertyName": "quarkus.http.cors.exposed-headers",
		"source": "io.quarkus.undertow.runtime.filters.CORSConfig#exposedHeaders"
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
