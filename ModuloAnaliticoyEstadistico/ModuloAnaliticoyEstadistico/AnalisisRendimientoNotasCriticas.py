# 4. Nota promedio general y por materia
promedio_general = df_notas['Nota'].mean()
promedios_por_materia = df_notas.groupby('Materia')['Nota'].mean().reset_index(name='Promedio')

# 5. Materias en Bajo Rendimiento
bajo_rendimiento = promedios_por_materia[promedios_por_materia['Promedio'] < UMBRAL_BAJO_RENDIMIENTO]

# 7. Notas Críticas (las 5 más bajas)
notas_criticas = df_notas.nsmallest(5, 'Nota')

print("\n### Reporte de Rendimiento ###")
print(f"Promedio General: {promedio_general:.2f}")
print("\nPromedios por Materia:")
print(promedios_por_materia)
print(f"\nMaterias con Bajo Rendimiento (Promedio < {UMBRAL_BAJO_RENDIMIENTO}):")
if not bajo_rendimiento.empty:
    print(bajo_rendimiento)
    # NOTIFICAR al familiar: Aquí se activaría el mecanismo de alerta en la API.
else:
    print("El estudiante no presenta bajo rendimiento en ninguna materia.")

print("\n5 Notas más Bajas (Críticas):")
print(notas_criticas)