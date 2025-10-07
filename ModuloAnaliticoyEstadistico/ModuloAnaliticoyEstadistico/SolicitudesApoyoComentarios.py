# 10. Solicitudes de apoyo: tipo y estado
resumen_solicitudes = df_solicitudes.groupby(['Tipo_Solicitud', 'Estado']).size().reset_index(name='Cantidad')

# 11. Detalle completo de Solicitudes (para ver el historial)
detalle_solicitudes = df_solicitudes[['Tipo_Solicitud', 'Estado', 'Fecha_Solicitud', 'Detalle']].sort_values(by='Fecha_Solicitud', ascending=False)

# 9. Últimos Comentarios/Recomendaciones
ultimos_comentarios = df_comentarios.sort_values(by='Fecha', ascending=False).head(3) # Mostrar los 3 más recientes

print("\n### Reporte de Solicitudes y Comentarios ###")
print("\nResumen de Solicitudes de Apoyo:")
print(resumen_solicitudes)

print("\nDetalle de Solicitudes (Visibilidad):")
print(detalle_solicitudes)

print("\nComentarios y Recomendaciones Recientes:")
print(ultimos_comentarios[['Fecha', 'Materia', 'Comentario']])