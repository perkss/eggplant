(ns eggplant.core
  (:require [clojure.test :refer :all]))

;; TODO Multiple parameters allowed
(defn given [x]
  (def given x))

;; TODO Multiple parameters allowed
(defn when [fn x]
  (fn x))

;; TODO need to make this equal work for all types
(defn then [expected actual]
  (is expected actual))
