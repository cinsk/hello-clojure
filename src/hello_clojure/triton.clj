(ns hello-clojure.triton)

(import (com.joyent.triton.config
         MapConfigContext
         ConfigContext
         EnvVarConfigContext
         DefaultsConfigContext
         SystemSettingsConfigContext
         ChainedConfigContext)
        (com.joyent.triton CloudApi Instances)
        )

(def config-context (ChainedConfigContext.
                     (into-array ConfigContext [(DefaultsConfigContext.)
                                                (EnvVarConfigContext.)
                                                (SystemSettingsConfigContext.)])))

(def ^:dynamic cloud-api (CloudApi. config-context))
(def instance-api (.instances cloud-api))

(defn instance-as-map [instance]
  {:name (.getName instance)
   :brand (.getBrand instance)
   :image (.getImage instance)
   :ips (.getIps instance)
   :memory (.getMemory instance)
   :disk (.getDisk instance)
   :metadata (.getMetadata instance)
   :tags (.getTags instance)
   :created (.getCreated instance)
   :updated (.getUpdated instance)
   :network (.getNetworks instance)
   :primaryIp (.getPrimaryIp instance)
   :firewallEnabled (.isFirewallEnabled instance)
   :computeNode (.getComputeNode instance)
   :packageName (.getPackageName instance)
   :packageId (.getPackageId instance)
   :dnsnames (.getDnsNames instance)
   :locality (.getLocality instance)
   })

(defn list
  ([] instances cloud-api)
  ([capi]
   (let [iapi (.instances capi)]
     (map instance-as-map (iterator-seq (.list iapi)))))
  )
