import pandas as pd
import numpy as np # Para simulación de datos
from collections import defaultdict

# --- SIMULACIÓN DE DATOS ---

# Datos del estudiante (Asistencia)
data_asistencia = {
    'Fecha': pd.to_datetime(pd.date_range(start='2024-08-01', periods=50)),
    'Materia': np.random.choice(['Matemáticas', 'Física', 'Literatura', 'Inglés'], size=50),
    'Estado': np.random.choice(['Presente', 'Ausente', 'Tardanza'], p=[0.85, 0.10, 0.05], size=50)
}
df_asistencia = pd.DataFrame(data_asistencia)

# Datos de Notas
data_notas = {
    'Materia': np.random.choice(['Matemáticas', 'Física', 'Literatura', 'Inglés'], size=60),
    'Actividad': [f'Quiz {i}' for i in range(15)] * 4,
    'Nota': np.random.uniform(2.0, 5.0, size=60).round(1) # Notas en escala 1.0 a 5.0
}
df_notas = pd.DataFrame(data_notas)

# Umbral de bajo rendimiento
UMBRAL_BAJO_RENDIMIENTO = 3.0

# Datos de Solicitudes de Apoyo
data_solicitudes = {
    'Tipo_Solicitud': np.random.choice(['Tutoría', 'Psicológico', 'Académico', 'Médico'], size=8),
    'Estado': np.random.choice(['Abierta', 'En Proceso', 'Cerrada'], size=8),
    'Fecha_Solicitud': pd.to_datetime(pd.date_range(start='2024-09-01', periods=8)),
    'Detalle': [f'Detalle solicitud {i}' for i in range(8)]
}
df_solicitudes = pd.DataFrame(data_solicitudes)

# Datos de Comentarios (Asumiendo una tabla de Comentarios de Profesores)
data_comentarios = {
    'Fecha': pd.to_datetime(pd.date_range(start='2024-09-01', periods=5)),
    'Materia': np.random.choice(['Matemáticas', 'Física', 'General'], size=5),
    'Comentario': [
        'Necesita reforzar fracciones.',
        'Excelente participación en clase.',
        'Mostrar más interés en la lectura.',
        'Entrega tardía de tareas.',
        'Mejoró su promedio general.'
    ]
}
df_comentarios = pd.DataFrame(data_comentarios)

print("Datos cargados y listos para el análisis.")