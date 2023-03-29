# Laboratorio-Arboles-AVL

## Me parecio el método más eficiente que hemos visto/utilizado hasta el momento

Este programa utiliza una clase `AVLTree` para implementar un árbol binario AVL y proporciona los siguientes métodos públicos:

- `insert(int data)` - inserta un dato en el árbol.
- `isAVL()` - devuelve verdadero si el árbol está balanceado y falso en caso contrario.
- `preorder()` - muestra el recorrido del árbol en preorden.
- `inorder()` - muestra el recorrido del árbol en inorden.
- `postorder()` - muestra el recorrido del árbol en postorden.
- `height()` - devuelve la altura del árbol.
- `leaves()` - muestra los nodos hoja del árbol.

El programa principal (`ArbolBinarioAVL`) crea una instancia de `AVLTree`, le pide al usuario que ingrese la cantidad de números a agregar y luego los agrega uno por uno al árbol. Luego, muestra si el árbol está balanceado, los recorridos en preorden, inorden y postorden, la altura del árbol y los nodos hoja del árbol.
