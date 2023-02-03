(ns codeduplicates.solution
  (:require [clojure.test :refer :all]))

(defn divisible?
  "Determine if a number is divisible by the divisor with no remainders."
  [div num]
  (zero? (mod num div)))


(defn is_multiplo? [value]
  (or (divisible? 3 value) (divisible? 5 value))
)

(defn add_value [origin value]
  (assoc origin :result  (+ (origin :result) value))
)

(defn evaluate_multiple [origin value]
  (if (is_multiplo? value)
    (add_value origin value)
    origin
  )
)

(defn solutionCodeDuplicates [a]
  (if  (< a 2)
    0
    ((reduce evaluate_multiple {:result 0} (range 3 a)) :result)
  )
)

(deftest evaluate_multiple_test
  (is (= (evaluate_multiple {:result 1} 4) {:result 1}))
  (is (= (evaluate_multiple {:result 1} 7) {:result 1}))
  (is (= (evaluate_multiple {:result 1} 3) {:result 4}))
  (is (= (evaluate_multiple {:result 1} 5) {:result 6}))
  (is (= (evaluate_multiple {:result 3} 15) {:result 18}))
  )

(deftest is_multiplo_test
  (is (= (is_multiplo? 1) false ))
  (is (= (is_multiplo? 3) true ))
  (is (= (is_multiplo? 5) true ))
  (is (= (is_multiplo? 15) true ))
  (is (= (is_multiplo? 12) true ))
)

(deftest add_value_test
  (is (= (add_value {:result 0} 1) {:result 1}))
  (is (= (add_value {:result 1} 1) {:result 2}))
  (is (= (add_value {:result 5} 15) {:result 20}))
)

(deftest testMeCodeDuplicates
  (testing "t1" (is (= (solutionCodeDuplicates -1 ) 0)))
  (testing "t2" (is (= (solutionCodeDuplicates -1 ) 0)))
  (is (= (solutionCodeDuplicates 10) 23))
  (is (= (solutionCodeDuplicates 12) 33))
  (is (= (solutionCodeDuplicates 13) 45))
)
