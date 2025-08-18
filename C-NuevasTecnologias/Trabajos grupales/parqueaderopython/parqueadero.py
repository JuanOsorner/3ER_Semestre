# main.py
from datetime import datetime, timedelta


# Estructuras de datos

parqueadero = []         
historial = []           

# Capacidad por tipo (ajusta a tu gusto)
CAPACIDAD_CARROS = 20
CAPACIDAD_MOTOS = 80



# Utilidades de tiempo

def _validar_hora(hora_str: str) -> bool:
    try:
        datetime.strptime(hora_str, "%H:%M")
        return True
    except ValueError:
        return False


def _pedir_hora(mensaje: str) -> str:
    """Pide una hora HH:MM; si se deja vacío, coloca la hora actual."""
    while True:
        h = input(mensaje).strip()
        if not h:
            return datetime.now().strftime("%H:%M")
        if _validar_hora(h):
            return h
        print("Formato inválido. Use HH:MM (ej. 08:05).")


def calcular_tiempo_horas(hora_entrada: str, hora_salida: str) -> float:
    """Diferencia en horas (positivo). Soporta cruce de medianoche."""
    t1 = datetime.strptime(hora_entrada, "%H:%M")
    t2 = datetime.strptime(hora_salida, "%H:%M")
    if t2 < t1:
        t2 += timedelta(days=1)  # salida al día siguiente
    delta = t2 - t1
    return delta.total_seconds() / 3600.0


def _ceil_horas(h: float) -> int:
    """Redondeo hacia arriba de horas positivas (sin importar fracción)."""
    h_int = int(h)
    return h_int if h == h_int else h_int + 1



# Funciones de HISTORIAL / INFORME

def agregar_a_historial(historial, placa, tipo, hora_entrada, hora_salida, tarifa):
    registro = {
        "placa": placa,
        "tipo": tipo,
        "hora_entrada": hora_entrada,
        "hora_salida": hora_salida,
        "tarifa": tarifa
    }
    historial.append(registro)


def generar_informe(historial):
    print("\n=== INFORME DE ACTIVIDADES ===")
    if not historial:
        print("No hay registros en el historial.")
        return
    for registro in historial:
        print(f"Placa: {registro['placa']}")
        print(f"Tipo: {registro['tipo']}")
        print(f"Hora Entrada: {registro['hora_entrada']}")
        print(f"Hora Salida: {registro['hora_salida']}")
        print(f"Tarifa: ${registro['tarifa']:.2f}")
        print("-" * 30)


def exportar_informe(historial, nombre_archivo="informe.txt"):
    with open(nombre_archivo, "w", encoding="utf-8") as archivo:
        archivo.write("=== INFORME DE ACTIVIDADES ===\n")
        if not historial:
            archivo.write("No hay registros en el historial.\n")
        else:
            for registro in historial:
                archivo.write(f"Placa: {registro['placa']}\n")
                archivo.write(f"Tipo: {registro['tipo']}\n")
                archivo.write(f"Hora Entrada: {registro['hora_entrada']}\n")
                archivo.write(f"Hora Salida: {registro['hora_salida']}\n")
                archivo.write(f"Tarifa: ${registro['tarifa']:.2f}\n")
                archivo.write("-" * 30 + "\n")
    print(f"Informe exportado correctamente como '{nombre_archivo}'")



# Función de TARIFAS

def calcularTarifas(horas, tipo):
    """
    tipo: '0' -> Carro | '1' -> Moto
    Reglas:
      - <1 hora: $0
      - <5 horas: se cobra por hora (redondeo hacia arriba)
      - >=5 horas: se cobra por días completos + resto
          * resto <5h -> por hora (redondeo hacia arriba)
          * resto >=5h -> un día adicional
    """
    if tipo == '0':          # Carro
        tarifa_hora = 4000
        tarifa_dia = 20000
    elif tipo == '1':        # Moto
        tarifa_hora = 2000
        tarifa_dia = 10000
    else:
        raise ValueError(f"Valor de tipo '{tipo}' inválido. Use '0' (Carro) o '1' (Moto).")

    if horas < 1:
        return 0

    if horas < 5:
        horas_cobradas = _ceil_horas(horas)
        return horas_cobradas * tarifa_hora

    dias_completos = int(horas // 24)
    resto = horas - dias_completos * 24
    total = dias_completos * tarifa_dia

    if resto == 0:
        return total
    if resto < 5:
        total += _ceil_horas(resto) * tarifa_hora
    else:
        total += tarifa_dia

    return total



# Registro/espacio 

def esta_registrado(parqueadero, placa):
    return any(v["datos"][0] == placa for v in parqueadero)


def hay_espacio(parqueadero, capacidad_maxima):
    return len(parqueadero) < capacidad_maxima



# Lógica del sistema

def registrar_entrada(parqueadero, capacidad_carros, capacidad_motos):
    placa = input("Ingrese la placa del vehículo: ").strip().upper()
    if not placa:
        print("Placa vacía. Cancelando registro.")
        return

    tipo = input("Ingrese el tipo de vehículo (Carro/Moto): ").strip().capitalize()
    if tipo not in ("Carro", "Moto"):
        print("Tipo inválido. Debe ser 'Carro' o 'Moto'.")
        return

    # Validación simple de formato por último carácter (como solicitaste)
    if tipo == "Carro" and placa[-1].isalpha():
        print("❌ Error: la placa ingresada parece de moto (termina en letra).")
        return
    if tipo == "Moto" and placa[-1].isdigit():
        print("❌ Error: la placa ingresada parece de carro (termina en número).")
        return

    # Capacidad por tipo
    total_carros = sum(1 for v in parqueadero if v["datos"][1] == "Carro")
    total_motos = sum(1 for v in parqueadero if v["datos"][1] == "Moto")

    # Capacidad total (usamos tu hay_espacio también)
    capacidad_total = capacidad_carros + capacidad_motos
    if not hay_espacio(parqueadero, capacidad_total):
        print("🚫 No hay espacio total disponible en el parqueadero.")
        return

    if tipo == "Carro" and total_carros >= capacidad_carros:
        print("🚫 No hay espacio disponible para más carros.")
        return
    if tipo == "Moto" and total_motos >= capacidad_motos:
        print("🚫 No hay espacio disponible para más motos.")
        return

    if esta_registrado(parqueadero, placa):
        print("⚠️ El vehículo ya está registrado en el parqueadero.")
        return

    hora_entrada = _pedir_hora("Ingrese la hora de entrada (HH:MM) [Enter = ahora]: ")

    vehiculo_dict = {
        "datos": (placa, tipo),
        "hora_entrada": hora_entrada
    }
    parqueadero.append(vehiculo_dict)
    print(f"✅ Vehículo {placa} ({tipo}) registrado exitosamente a las {hora_entrada}.")


def registrar_salida(parqueadero):
    if not parqueadero:
        print("No hay vehículos registrados actualmente.")
        return

    placa = input("Ingrese la placa del vehículo que va a salir: ").strip().upper()
    vehiculo = next((v for v in parqueadero if v["datos"][0] == placa), None)
    if not vehiculo:
        print("El vehículo no está registrado en el parqueadero.")
        return

    hora_salida = _pedir_hora("Ingrese la hora de salida (HH:MM) [Enter = ahora]: ")

    hora_entrada = vehiculo["hora_entrada"]
    tipo_str = vehiculo["datos"][1]
    horas = calcular_tiempo_horas(hora_entrada, hora_salida)

    # Mapear tipo a tu función de tarifa ('0' carro, '1' moto)
    tipo_code = '0' if tipo_str == "Carro" else '1'
    tarifa = calcularTarifas(horas, tipo_code)

    print(f"Tiempo estacionado: {horas:.2f} horas")
    print(f"💰 Tarifa a pagar: ${tarifa}")

    # Agregar a historial usando tu función
    agregar_a_historial(historial, placa, tipo_str, hora_entrada, hora_salida, tarifa)

    # Retirar del parqueadero
    parqueadero.remove(vehiculo)
    print("✅ Salida registrada y vehículo retirado del parqueadero.")


def mostrar_vehiculos(parqueadero):
    if not parqueadero:
        print("📭 No hay vehículos registrados.")
        return
    print("\n🚗 Vehículos en el parqueadero:")
    for i, vehiculo in enumerate(parqueadero, 1):
        placa, tipo = vehiculo["datos"]
        hora = vehiculo["hora_entrada"]
        print(f"{i}. {placa} - {tipo} - Hora de entrada: {hora}")


def menu_principal():
    while True:
        print("\n===== MENÚ PARQUEADERO =====")
        print("1. Registrar entrada")
        print("2. Registrar salida")
        print("3. Ver vehículos estacionados")
        print("4. Generar informe (pantalla)")
        print("5. Exportar informe a TXT")
        print("6. Salir")
        opcion = input("Seleccione una opción: ").strip()

        if opcion == "1":
            registrar_entrada(parqueadero, CAPACIDAD_CARROS, CAPACIDAD_MOTOS)
        elif opcion == "2":
            registrar_salida(parqueadero)
        elif opcion == "3":
            mostrar_vehiculos(parqueadero)
        elif opcion == "4":
            generar_informe(historial)
        elif opcion == "5":
            nombre = input("Nombre de archivo [informe.txt]: ").strip() or "informe.txt"
            exportar_informe(historial, nombre_archivo=nombre)
        elif opcion == "6":
            print("👋 Saliendo del sistema...")
            break
        else:
            print("❌ Opción inválida, intente nuevamente.")


if __name__ == "__main__":
    menu_principal()

      
   


        

        
                 



   
