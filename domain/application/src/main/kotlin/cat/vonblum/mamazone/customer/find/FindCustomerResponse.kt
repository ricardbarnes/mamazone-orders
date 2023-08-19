package cat.vonblum.mamazone.customer.find

import cat.vonblum.mamazone.shared.domain.bus.query.Response

class FindCustomerResponse(val id: Int, val email: String, val name: String, val surname: String) : Response