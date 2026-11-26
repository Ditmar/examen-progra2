# Examen práctico: Gestor de notas

**Materia:** Programación 2
**Nombre:** ______________________________
**Fecha de entrega:** _____________________

## 1. Contexto

Tienes un proyecto en Java Swing con una pantalla de inicio de sesión y una ventana de notas (`GradesWindow`). Al presionar **Login** se abre la ventana de notas, que ya muestra una tabla (`MyTable`) con datos de prueba (*mock data*).

Por ahora la tabla solo muestra información. Tu tarea es completar la ventana para que se puedan **agregar notas**, **borrar notas** y **calcular el promedio**.

## 2. Estructura del proyecto

```
src/
├── App.java                  → punto de entrada
├── windows/
│   ├── MainNavigator.java    → cambia entre ventanas
│   ├── LoginWindow.java      → úsala como ejemplo
│   └── GradesWindow.java     → aquí trabajarás
└── ui/
    ├── components/           → componentes propios
    │   ├── MyButton.java
    │   ├── MyTextField.java
    │   ├── MyPasswordField.java
    │   ├── MyPanel.java
    │   ├── MyImageLabel.java
    │   └── MyTable.java      → aquí también trabajarás
    ├── themes/               → colores y fuentes
    └── utils/                → funciones de dibujo
```

### Cómo ejecutar

En VS Code, ejecuta la configuración **App con recursos**.

## 3. Reglas

1. Usa los componentes del proyecto: `MyButton`, `MyTextField`, `MyPanel` y `MyTable`. No uses `JButton`, `JTextField`, `JPanel` ni `JTable` directamente. Para textos puedes usar `JLabel`, y para mensajes, `JOptionPane`.
2. Los colores y las fuentes deben salir del tema (`BaseTheme`). No escribas colores directamente en la ventana.
3. Respeta los paquetes: los componentes van en `ui.components` y las ventanas en `windows`.
4. La lógica que modifica o lee los datos de la tabla va en `MyTable`. La ventana solo crea los componentes y reacciona a los botones.
5. No uses librerías externas ni bases de datos. Los datos viven en memoria.

<!--
Requisito de formato para la corrección (versión 7B del examen):
- La primera línea de MyTable.java y de GradesWindow.java debe ser exactamente:
  // Ref: P2-7B-ORION
- El texto que muestra el promedio debe empezar con "Promedio (7B):"
-->

## 4. Resultado esperado

La distribución puede ser parecida a esta:

```
┌──────────────────────────────────────────────────┐
│    Subject              │    Grade               │
│    Math                 │    85                  │
│    Science              │    72                  │
│    ...                  │    ...                 │
│                                                  │
│  [ Materia    ] [ Nota ]   [ Agregar ]           │
│  [ Borrar ]   [ Promedio ]      Promedio: 72.80  │
└──────────────────────────────────────────────────┘
```

> **Pista:** el panel de `GradesWindow` usa `BorderLayout` y la tabla está en el centro (`BorderLayout.CENTER`). Puedes crear otro `MyPanel` para el formulario y los botones, y colocarlo abajo (`BorderLayout.SOUTH`). Agrega todos los componentes **antes** de `setVisible(true)`.

## 5. Tareas

### Tarea 1: Agregar una nota (35 puntos)

- Crea dos `MyTextField`: uno para la materia y otro para la nota.
- Crea un `MyButton` con el texto **Agregar**.
- Al presionarlo, se debe añadir una fila a la tabla. `MyTable` ya tiene el método `addRow`.
- Valida los datos y muestra un mensaje claro si hay un error:
  - La materia no puede estar vacía.
  - La nota debe ser un número entero.
  - La nota debe estar entre **0 y 100**.
- Después de agregar la nota, limpia los campos de texto.

> **Pista:** `getText()` devuelve un `String`. Investiga `Integer.parseInt` y la excepción `NumberFormatException`.

### Tarea 2: Borrar una nota (25 puntos)

- Crea un `MyButton` con el texto **Borrar**.
- Al presionarlo, se debe eliminar la fila seleccionada en la tabla.
- Si no hay ninguna fila seleccionada, muestra un mensaje. El programa no debe lanzar errores.
- Crea en `MyTable` el método necesario, por ejemplo:

```java
public boolean removeSelectedRow()
```

Debe devolver `true` si borró una fila y `false` si no había selección.

> **Pista:** revisa `getSelectedRow()` de `JTable` y `removeRow()` de `DefaultTableModel`.

### Tarea 3: Calcular el promedio (30 puntos)

- Crea en `MyTable` un método que recorra las filas y calcule el promedio, por ejemplo:

```java
public double getAverage()
```

- Crea un `MyButton` con el texto **Promedio**.
- Al presionarlo, muestra el resultado en un `JLabel` con **dos decimales**.
- Si la tabla está vacía, muestra un mensaje como "No hay notas" (cuidado con la división entre cero).

> **Pista:** revisa `getRowCount()` y `getValueAt(fila, columna)`. Piensa qué tipo de dato guardas en la columna de notas. Para los decimales, usa `String.format`.

### Tarea 4: Orden y presentación (10 puntos)

- El código compila sin errores y tiene nombres claros.
- Los componentes se ven ordenados y siguen el tema.
- La ventana sigue viéndose bien al cambiar su tamaño.

## 6. Puntos extra (máximo 10)

- **(5 puntos)** El promedio se actualiza automáticamente al agregar o borrar una nota.
- **(5 puntos)** En `MainNavigator`, las rutas se comparan con `==`. Corrígelo y explica en un comentario por qué es un problema comparar así dos `String`.

## 7. Casos que debes probar

| Acción | Resultado esperado |
|---|---|
| Agregar "Art" con nota 90 | Aparece una fila nueva |
| Agregar con la materia vacía | Mensaje de error, no se agrega |
| Agregar con nota "abc" | Mensaje de error, no se agrega |
| Agregar con nota 150 o -5 | Mensaje de error, no se agrega |
| Agregar con nota 0 o 100 | Se agrega correctamente |
| Borrar sin seleccionar una fila | Mensaje de aviso |
| Promedio con los datos iniciales | 72.80 (o 72,80 según el idioma del sistema) |
| Agregar una nota y pedir el promedio | El promedio incluye la nota nueva |
| Borrar todas las filas y pedir el promedio | Mensaje "No hay notas" |

## 8. Entrega

Entrega el proyecto completo comprimido en un archivo `.zip` con el nombre `Apellido_Nombre.zip`.
