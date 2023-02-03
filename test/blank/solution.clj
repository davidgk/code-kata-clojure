(ns blank.solution
  (:require [clojure.test :refer :all]))

(defn solution [a b] (+ a b))

(deftest testMe
  (testing "t1" (is (= (solution 1 2 ) 3)))
)
; How to load this in repl
;(load "../../test/blank/solution")
;(in-ns 'blank.solution)