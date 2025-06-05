import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np

# Configuración de estilo
try:
    plt.style.use('seaborn-v0_8')  # Intenta con el estilo más reciente
except:
    plt.style.use('ggplot')  # Fallback a un estilo alternativo

sns.set_palette("husl")
plt.rcParams['figure.facecolor'] = 'white'
plt.rcParams['axes.grid'] = True  # Agregar grid para mejor lectura

# Datos de los modelos
data = {
    'Modelo': [
        'Regresión Logística', 
        'RF (Cosine-IR)', 
        'RF (Cosine-text)',
        'RF (Cosine-AST)',
        'RF (Jaccard-text)',
        'RF (Jaccard-AST)',
        'RF (All features)',
        'XGBoost (All)'
    ],
    'Tipo': [
        'Regresión Logística',
        'Random Forest',
        'Random Forest',
        'Random Forest',
        'Random Forest',
        'Random Forest',
        'Random Forest',
        'XGBoost'
    ],
    'F1 Score': [0.8516, 0.8406, 0.9315, 0.9459, 0.9014, 0.9600, 0.9459, 0.9500],
    'Accuracy': [0.7619, 0.7609, 0.8810, 0.9048, 0.8333, 0.9286, 0.9048, 0.9048]
}

df = pd.DataFrame(data)

# Orden personalizado para los modelos
model_order = [
    'Regresión Logística',
    'RF (Cosine-IR)',
    'RF (Cosine-text)',
    'RF (Cosine-AST)',
    'RF (Jaccard-text)',
    'RF (Jaccard-AST)',
    'RF (All features)',
    'XGBoost (All)'
]

# Crear figura con tamaño optimizado
plt.figure(figsize=(12, 6.5))

# Gráfico de barras con mejoras visuales
ax = sns.barplot(
    x='Modelo', 
    y='F1 Score', 
    data=df, 
    order=model_order, 
    hue='Tipo', 
    dodge=False,
    edgecolor='black',  # Bordes definidos
    linewidth=0.7,      # Grosor del borde
    alpha=0.85         # Ligera transparencia
)

# Personalización avanzada del gráfico
plt.title('Comparación del F1-Score entre Modelos de Detección de Plagio\n', 
          fontsize=15, 
          fontweight='bold',
          pad=20)
plt.xlabel('\nModelo y Features Utilizados', fontsize=12)
plt.ylabel('F1-Score\n', fontsize=12)
plt.ylim(0.7, 1.0)

# Rotación y estilo de etiquetas
plt.xticks(
    rotation=45, 
    ha='right', 
    rotation_mode='anchor', 
    fontsize=11
)

# Añadir valores con formato mejorado
for p in ax.patches:
    ax.annotate(
        f"{p.get_height():.4f}",  # Mostrar 4 decimales
        (p.get_x() + p.get_width() / 2., p.get_height()), 
        ha='center', 
        va='center', 
        xytext=(0, 7),  # Ajuste vertical
        textcoords='offset points',
        fontsize=10,
        fontweight='bold',
        bbox=dict(  # Caja alrededor del texto
            boxstyle='round,pad=0.3',
            facecolor='white',
            edgecolor='gray',
            alpha=0.7
        )
    )

# Línea horizontal para el máximo F1-Score
max_f1 = df['F1 Score'].max()
plt.axhline(
    y=max_f1, 
    color='red', 
    linestyle='--', 
    alpha=0.6, 
    linewidth=1.8
)

# Texto informativo del máximo
plt.text(
    len(model_order)-0.5, 
    max_f1+0.01, 
    f'Máximo F1-Score: {max_f1:.4f}', 
    color='red', 
    fontsize=11,
    fontweight='bold',
    bbox=dict(
        facecolor='white', 
        alpha=0.8, 
        edgecolor='red',
        boxstyle='round,pad=0.3'
    )
)

# Leyenda mejorada
legend = plt.legend(
    title='Tipo de Modelo',
    bbox_to_anchor=(1.05, 1), 
    loc='upper left',
    frameon=True,
    framealpha=0.9,
    edgecolor='black'
)
legend.get_title().set_fontsize('11')  # Tamaño del título de la leyenda

# Grid horizontal para mejor lectura
ax.yaxis.grid(True, linestyle='--', alpha=0.4)

# Ajuste de márgenes
plt.subplots_adjust(
    bottom=0.22,  # Más espacio para etiquetas
    top=0.9,      # Espacio superior
    right=0.85    # Espacio para leyenda
)

# Mostrar gráfico
plt.tight_layout()
plt.show()