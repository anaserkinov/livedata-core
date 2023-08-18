package androidx.lifecycle

class DisposableLiveData<T>: MutableLiveData<T> {

    constructor(): super()
    constructor(value: T): super(value)

    private var isNew = true

    override fun setValue(value: T) {
        isNew = true
        super.setValue(value)
    }

    override fun canNotify(): Boolean {
        return isNew
    }

    override fun notified() {
        isNew = false
    }

}