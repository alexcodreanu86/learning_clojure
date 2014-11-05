(ns ttt.templates)

(defn render-row [first-el second-el third-el]
  (str (or first-el " ") "|" (or second-el " ") "|" (or third-el " ")))

(defn render-row-elements [board offset]
  (render-row
    (board (+ 0 offset))
    (board (+ 1 offset))
    (board (+ 2 offset))))

(defn render-line-separator []
  "\n-----\n")

(defn render-board [board]
  (str (render-row-elements board 0)
       (render-line-separator)
       (render-row-elements board 3)
       (render-line-separator)
       (render-row-elements board 6)))
