package cat.vonblum.mamazone.customer

class CustomerAddress(
    private var line: CustomerAddressLine,
    private var postcode: CustomerAddressPostcode,
    private var country: CustomerAddressCountry
) {

    fun line(): CustomerAddressLine = this.line

    fun postcode(): CustomerAddressPostcode = this.postcode

    fun country(): CustomerAddressCountry = this.country

    fun modifyLine(line: CustomerAddressLine) {
        this.line = line
    }

    fun modifyPostcode(postcode: CustomerAddressPostcode) {
        this.postcode
    }

    fun modifyCountry(country: CustomerAddressCountry) {
        this.country = country
    }

}