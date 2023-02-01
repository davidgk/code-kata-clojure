(ns codeduplicates.solution
  (:require [clojure.test :refer :all]))

(defn divisible?
  "Determine if a number is divisible by the divisor with no remainders."
  [div num]
  (zero? (mod num div)))


(defn is_multiplo? [value]
  (or (divisible? 3 value) (divisible? 5 value))
)

(defn check_list [origin value]
  ( if (.contains origin value)
      origin
      (conj origin value)
  )
)

(defn evaluate_multiple [origin value]
  (if (is_multiplo? value)
    (check_list origin value)
    origin
  )
)

(defn add_values [values]
  (reduce (fn [ori val] (+ ori val)) 0  values)
)


(defn evaluate [a]
   (def values (reduce evaluate_multiple [] (range 3 a)))
   (add_values values)
)

(defn solution [a]
  (if  (< a 2)
    0
    (evaluate a)
  )
)

(deftest evaluate_test
  (is (= (evaluate 10) 23))
  (is (= (evaluate 12) 33))
  (is (= (evaluate 13) 45))
)

(deftest add_values_test
  (is (= (add_values [3 5 9]) 17))
  (is (= (add_values [3 5 6 9]) 23))
  )

(deftest evaluate_multiple_test
  (is (= (evaluate_multiple [] 4) []))
  (is (= (evaluate_multiple [] 7) []))
  (is (= (evaluate_multiple [] 3) [3]))
  (is (= (evaluate_multiple [] 5) [5]))
  (is (= (evaluate_multiple [3 5] 5) [3 5]))
  (is (= (evaluate_multiple [3 5] 15) [3 5 15]))
  )

(deftest is_multiplo_test
  (is (= (is_multiplo? 1) false ))
  (is (= (is_multiplo? 3) true ))
  (is (= (is_multiplo? 5) true ))
  (is (= (is_multiplo? 15) true ))
  (is (= (is_multiplo? 12) true ))
)

(deftest check_list_test
  (is (= (check_list [] 1) [1]))
  (is (= (check_list [1] 1) [1]))
  (is (= (check_list [3 5] 9) [3 5 9]))
)

(deftest testMe
  (testing "t1" (is (= (solution -1 ) 0)))
  (testing "t2" (is (= (solution -1 ) 0)))
  (is (= (solution 10) 23))
  (is (= (solution 12) 33))
  (is (= (solution 13) 45))
)
