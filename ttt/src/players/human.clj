(ns players.human
(:require [ttt.display :refer [get-user-input]]
          [ttt.board   :refer [valid-move?]]))

(defn get-int-input []
  (read-string (get-user-input)))

(defn next-human-move [board]
  (let [input (get-int-input)]
    (if (and (nil? (board input)) (valid-move? input))
      input
      (next-human-move board))))
