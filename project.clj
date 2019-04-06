(defproject eggplant "0.2.1-SNAPSHOT"
  :description "Eggplant is a very young behaviour driven development (BDD) library for Clojure. Eggplant will focus on data driven testing to enable a data driven language such as Clojure to be adequetly tested. It will use specifications written in user friendly language to enforce executable tests that can be automated and continue living documentation of these tests.\n\nFeatures (Under Development): Give, When, Then style of testing. Data driven testing using data tables. Import of data tables from CSV for non technical users to write specifications."
  :url "https://github.com/perkss/eggplant"
  :license {:name "Apache License"
            :url  "https://github.com/perkss/eggplant/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :plugins [[lein-environ "1.0.1"]
            [lein-cljfmt "0.6.4"]])
