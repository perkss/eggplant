(ns eggplant.core
  (:require [clojure.test :refer :all]))

;; TODO Multiple parameters allowed
(defn given [x]
  (var-get (def var x)))

(defn when-we-process [test-fn & data]
  (apply test-fn data))

;; TODO need to make this equal work for all types
(defn then-we-expect [expected actual]
  (is (true? (= expected actual))))

(defn then-we-do-not-expect [expected actual]
  (is (false? (= expected actual))))

;; TODO define a defspecification fn that refers to deftest or testing
(defmacro defspecification
  [specName & testBody]
    `(def ~(vary-meta specName assoc :test `(fn [] ~@testBody))
       (fn [] (test-var (var ~specName)))))




