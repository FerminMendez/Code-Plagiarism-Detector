# Detector de Plagio en Código Java 🧠💻
## Descripción del Proyecto
Este proyecto implementa un sistema de detección de plagio en código fuente. El objetivo es identificar similitudes entre fragmentos de código utilizando técnicas de procesamiento de texto y aprendizaje automático. El sistema puede ser útil para entornos académicos o profesionales donde la originalidad del código es fundamental.

## Descripcipon del repositorio

En este repositorio encontraras:

Code: carpeta que contiene main.ipynb que es el noteook principal que contiene todos los apsos para generar los modelos

Folders para almacenar los datasets
- Combnined_Plagiarism_Dataset: Que es el dataset principal los demás son pasos intermedios para llegar a esa estructura
- Fire14 hace referencia al dataset de fire14
- IR-Plag-Dataset: 

Model: Carpeta donde se guardan los modelos ejecutados

Presentación: Power Point que contiene la presentación para este proyecto.

## Descripción del Dataset
Se utiliza un conjunto de datos compuesto por fragmentos de código fuente etiquetados en carpetas como plagiados, originales y no plagiados. Este dataset está diseñado para entrenar y evaluar modelos de detección de plagio y simula escenarios reales de duplicación con o sin modificaciones menores.

Cada entrada del dataset contiene:

* Java code: Fragmento de código en Java.


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

## Funciones para obtener los feautures para el modelo
Dado el dataset procesado el notebook tiene la opción de generar y elegir los features para entrenar los modelos.

1. Cosine similarity plain text
2. Cosine similarity tokenized string AST
3. Jaccard similarity plain text
4. accard similarity tokenized string AST

## Declaración de los modelos

La sección de modelos tiene los modelos declarados inmediatamente se selecciona solo el modelo que se va a entrenar
ya tiene una interfaz lista para solo seleccionar el modelo y directamente entrenarlo y evaluarlo.


