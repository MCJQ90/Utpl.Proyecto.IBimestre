workspace "Contador en Línea para PYMEs" {
    description "Sistema para automatizar el proceso de declaracion de impuesto a la renta para PYMES."

    model {
        pCliente = person "Cliente"
        pAsistente = person "Asistente Contable"
        pContador = person "Contador"

        sSRI = softwareSystem "Sistema del SRI" {
            tags "Externo"
        }

        sContador = softwareSystem "Contador en Línea" {
            tags "SistemaContador"

            portalCliente = container "Portal del Cliente" {
                tags "AppMovil"
                pCliente -> this "Solicita servicio, consulta estado"
            }

            portalInterno = container "Portal Interno" {
                tags "AppWeb"
                pAsistente -> this "Ingresa información y genera proforma"
                pContador -> this "Revisa conciliaciones y valida declaración"
            }

            apiContador = container "API del sistema" {
                tags "Api"
                portalCliente -> this "Envía y consulta datos"
                portalInterno -> this "Envía y consulta datos"
                this -> sSRI "Consulta y envía declaraciones"
                
                asignacionComponente = component "Componente de Asignación" "Asigna tareas automáticamente al asistente disponible"
                estadoComponente = component "Componente de Estado del Proceso" "Informa al cliente sobre el estado de su solicitud"
                conciliacionComponente = component "Conciliación Tributaria" "Calcula automáticamente base imponible, retenciones e impuesto a pagar"

            }

            baseDatos = container "Base de Datos del sistema" {
                tags "Database"
                apiContador -> this "CRUD sobre clientes, solicitudes, ingresos, gastos, conciliaciones y declaraciones"
            }
        }
    }

    views {
        systemContext sContador {
            include *
            autolayout lr
        }

        container sContador {
            include *
            autolayout lr
        }
        
        component apiContador {
            include *
            autolayout lr
        }

        styles {
            element "SistemaContador" {
                shape RoundedBox
                background #206BA4
                color #ffffff
            }

            element "AppMovil" {
                shape MobileDevicePortrait
                background #91C9F7
                color #000000
            }

            element "Api" {
                shape Hexagon
            }

            element "Database" {
                shape Cylinder
                background #6FCF97
            }

            element "Externo" {
                shape Box
                background #42a5f5
                color #ffffff
            }
        }

        theme "https://srv-si-001.utpl.edu.ec/REST_PRO_ERP/Recursos/Imagenes/themeAZ_2023.json"
    }
}

