(ns eggplant.core
  (:require [clojure.test :refer :all]))

;; TODO Multiple parameters allowed
(defn provided [x]
  (def provided x))

;; TODO Multiple parameters allowed
;; could also bind this to symbol or global var so is not nested call
(defn when-we [fn x]
  (fn x))

;; TODO need to make this equal work for all types
(defn then-we-expect [expected actual]
  (= expected actual))

