(ns fizzbuzz.core)

(defn divizible-by? [number divider]
  (zero? (mod number divider)))

(defn check-dividing-with-value [number divider value]
  (if (divizible-by? number divider)
    value
    ""))

(defn process-fizzbuzz [number]
  (let [cumulator (check-dividing-with-value number 3 "fizz")]
    (str cumulator (check-dividing-with-value number 5 "buzz"))))

(defn fizzbuzz [number]
  (let [processed-result (process-fizzbuzz number)]
    (if (empty? processed-result)
      number
      processed-result)))
