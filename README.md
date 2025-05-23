# Detector de Plagio de Código 🧠💻
## Descripción del Proyecto
Este proyecto implementa un sistema de detección de plagio en código fuente. El objetivo es identificar similitudes entre fragmentos de código utilizando técnicas de procesamiento de texto y aprendizaje automático. El sistema puede ser útil para entornos académicos o profesionales donde la originalidad del código es fundamental.

## Descripción del Dataset
Se utiliza un conjunto de datos compuesto por fragmentos de código fuente etiquetados como plagiados o originales. Este dataset está diseñado para entrenar y evaluar modelos de detección de plagio y simula escenarios reales de duplicación con o sin modificaciones menores.

Cada entrada del dataset contiene:

file_name: Nombre del archivo fuente.

code: Fragmento de código en distintos lenguajes (e.g., Python, Java, C++).

author: Identificador del autor original.

label: Etiqueta binaria que indica si el código es original (0) o plagiado (1).

El 5% de los datos puede tener campos faltantes (como el autor) para reflejar la naturaleza incompleta de la información en casos reales.

# Proceso del Proyecto
## Recolección y Preparación del Dataset
El dataset fue obtenido desde la plataforma de Canvas a un link de OneDrive. Posteriormente se almacenó en Google Drive para facilitar su acceso y manipulación en el modelo de machine learning.

## Preprocesamiento y División de Datos
Se aplicaron técnicas de limpieza y normalización del código fuente, tales como:

* Eliminación de comentarios y espacios innecesarios.

* Estandarización del estilo de código (minimización de variaciones superficiales).

* Tokenización y extracción de características sintácticas.

Luego, el dataset fue dividido en:

* Entrenamiento: 80%

* Prueba: 20%

## Vectorización y Escalamiento
Se utilizó TF-IDF para representar los fragmentos de código como vectores numéricos, ignorando tokens demasiado comunes que no aportan valor semántico. Esta transformación convierte el texto en una matriz dispersa, optimizada para su procesamiento por modelos de aprendizaje supervisado.
