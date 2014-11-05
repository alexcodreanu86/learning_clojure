(ns ttt.board)

(def possible-moves
  (set (range 9)))

(def winning-combinations
  ['(0 1 2)
   '(3 4 5)
   '(6 7 8)
   '(0 3 6)
   '(1 4 7)
   '(2 5 8)
   '(0 4 8)
   '(6 4 2)])

(defn valid-moves [board]
  (sort (vec (clojure.set/difference possible-moves (set (keys board))))))

(defn valid-move? [move]
  (contains? possible-moves move))

(defn is-taken-position? [position board]
  (not (nil? (board position))))

(defn same-elements-in-combo? [combo board]
  (= (board (first combo))
     (board (second combo))
     (board (nth combo 2))))

(defn has-winning-positions [combo board]
  (and (is-taken-position? (first combo) board)
       (same-elements-in-combo? combo board)))

(defn get-winning-combination [board]
 (first (for [combo winning-combinations :when (has-winning-positions combo board)]
    combo )))

(defn has-winner? [board]
  (let [winning-combo (get-winning-combination board)]
    (if winning-combo true false)))

(defn full-board? [board] (empty? (valid-moves board)))

(defn is-game-over? [board]
  (or (has-winner? board) (full-board? board)))

(defn get-winner [board]
  (board (first (get-winning-combination board))))
