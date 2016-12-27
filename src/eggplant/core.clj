(ns eggplant.core
  (:require [clojure.test :refer :all]))

;; TODO Multiple parameters allowed
(defn provided [x]
  (def provided x))

;; TODO Multiple parameters allowed
(defn when-we [fn x]
  (fn x))

;; TODO need to make this equal work for all types
(defn then-we-expect [expected actual]
  (is expected actual))

