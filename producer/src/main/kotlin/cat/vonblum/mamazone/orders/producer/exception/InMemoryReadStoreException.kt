package cat.vonblum.mamazone.orders.producer.exception

import cat.vonblum.mamazone.orders.shared.infrastructure.store.inmemory.InMemoryException

class InMemoryReadStoreException(message: String) : InMemoryException(message) {

    companion object {

        fun instance(): InMemoryReadStoreException {
            return InMemoryReadStoreException("A read store cannot write!")
        }

    }

}