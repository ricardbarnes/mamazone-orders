package cat.vonblum.mamazone.product.find

import cat.vonblum.mamazone.shared.domain.bus.query.Response

class FindProductResponse(val id: Int, val name: String, val status: String, val image: Map<String, Any>) : Response