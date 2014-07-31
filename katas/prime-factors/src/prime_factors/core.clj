(ns prime-factors.core)

(defn divizible-by? [number divider]
  (zero? (mod number divider)))

(defn prime-factors [x]
  (loop [remainder x
         factors []
         next-factor 2]
    (if (< remainder next-factor)
      factors
      (if (divizible-by? remainder next-factor)
        (recur (/ remainder next-factor)
               (conj factors next-factor)
               next-factor)
        (recur remainder factors (inc next-factor))))))
