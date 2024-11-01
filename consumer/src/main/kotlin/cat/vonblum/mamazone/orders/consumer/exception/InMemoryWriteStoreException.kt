package cat.vonblum.mamazone.orders.consumer.exception

import cat.vonblum.mamazone.orders.shared.infrastructure.store.inmemory.InMemoryException

class InMemoryWriteStoreException(message: String) : InMemoryException(message) {

    companion object {

        fun instance(): InMemoryWriteStoreException {
            return InMemoryWriteStoreException("A write store cannot read!")
        }

    }

}