(ns fizzbuzz.core)

(defn divizible-by? [divider number]
  (zero? (mod number divider)))

(defn check-dividing-with-value [x, divider, value]
  (if (divizible-by? divider x)
    value
    ""))

(defn process-fizzbuzz [x]
  (let [cumulator (check-dividing-with-value x 3 "fizz")]
    (str cumulator (check-dividing-with-value x 5 "buzz"))))

(defn fizzbuzz [x]
  (let [processed-string (process-fizzbuzz x)]
    (if (zero? (count processed-string))
      x
      processed-string)))
