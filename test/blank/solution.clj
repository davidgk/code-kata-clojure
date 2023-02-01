(ns blank.solution
  (:require [clojure.test :refer :all]))

(defn solution [a b] (+ a b))

(deftest testMe
  (testing "t1" (is (= (solution 1 2 ) 3)))
)
