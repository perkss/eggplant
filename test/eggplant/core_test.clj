(ns eggplant.core-test
  (:require [clojure.test :refer :all])
  (:require [eggplant.core :refer [get-fn-name-from-str]]))

(deftest get-fn-from-str-max-test
  (testing "Get ns and fn name word from a str"
    (is (= ["clojure.core" "max"]
           (get-fn-name-from-str "the #max of :a and :b")))))

(deftest get-fn-from-str-multiply-test
  (testing "Get ns and fn name from a str"
    (is (= ["clojure.core" "*"]
           (get-fn-name-from-str "the #* of :a and :b")))))

(deftest get-fn-uppercase-test
  (testing "Get the namespace and fn name for string uppercase"
    (is (= ["clojure.string" "uppercase"]
           (get-fn-name-from-str "the #clojure.string/uppercase of :a and :b")))))
