(ns players.ai
  (:require [ttt.board :refer :all]))

(defn next-ai-move [board]
  (first (valid-moves board)))
