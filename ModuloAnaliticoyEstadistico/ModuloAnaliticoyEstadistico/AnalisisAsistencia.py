# 1. Porcentaje de asistencia general y por materia
total_clases = len(df_asistencia)
total_presente = len(df_asistencia[df_asistencia['Estado'] == 'Presente'])
porcentaje_asistencia_general = (total_presente / total_clases) * 100

reporte_asistencia_materia = df_asistencia.groupby('Materia')['Estado'].value_counts(normalize=True).mul(100).rename('Porcentaje').reset_index()
reporte_asistencia_materia = reporte_asistencia_materia[reporte_asistencia_materia['Estado'] == 'Presente']

# 3. Conteo de ausencias
conteo_ausencias = df_asistencia['Estado'].value_counts().get('Ausente', 0)
conteo_tardanzas = df_asistencia['Estado'].value_counts().get('Tardanza', 0)

print("\n### Reporte de Asistencia ###")
print(f"Asistencia General: {porcentaje_asistencia_general:.2f}%")
print(f"Total Ausencias: {conteo_ausencias}")
print(f"Total Tardanzas: {conteo_tardanzas}")
print("\nAsistencia por Materia (Presente):")
print(reporte_asistencia_materia[['Materia', 'Porcentaje']])