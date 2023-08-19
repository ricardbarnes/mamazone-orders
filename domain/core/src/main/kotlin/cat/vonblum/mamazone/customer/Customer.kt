package cat.vonblum.mamazone.customer

import cat.vonblum.mamazone.shared.domain.aggregate.AggregateRoot

class Customer(
    private val id: CustomerId,
    private var email: CustomerEmail,
    private var name: CustomerName,
    private var surname: CustomerSurname,
    private var address: CustomerAddress
) : AggregateRoot() {

    companion object {

        fun create(
            id: CustomerId,
            email: CustomerEmail,
            name: CustomerName,
            surname: CustomerSurname,
            address: CustomerAddress
        ): Customer = Customer(
            id, email, name, surname, address
        ).also { customer ->
            customer.record(
                CustomerCreatedEvent(
                    customer.id.value,
                    customer.email.value,
                    customer.name.value,
                    customer.surname.value,
                    mapOf(
                        "addressLine" to customer.address.line().value,
                        "addressPostcode" to customer.address.postcode().value,
                        "addressCountry" to customer.address.country().value
                    )
                )
            )
        }

    }

    fun id(): CustomerId = this.id

    fun email(): CustomerEmail = this.email

    fun name(): CustomerName = this.name

    fun surname(): CustomerSurname = this.surname

    fun address(): CustomerAddress = this.address

    fun modifyEmail(email: CustomerEmail) = let {
        this.email = email
        this.recordModification()
    }

    fun modifyName(name: CustomerName) = let {
        this.name = name
        this.recordModification()
    }

    fun modifySurname(surname: CustomerSurname) = let {
        this.surname = surname
        this.recordModification()
    }

    private fun recordModification() = this.record(
        CustomerModifiedEvent(
            this.id.value, this.email.value, this.name.value, this.surname.value, mapOf(
                "addressLine" to address.line().value,
                "addressPostcode" to address.postcode().value,
                "addressCountry" to address.country().value
            )
        )
    )

}