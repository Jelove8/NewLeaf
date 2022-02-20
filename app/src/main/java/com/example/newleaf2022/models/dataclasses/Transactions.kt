package com.example.newleaf2022.models.dataclasses

data class Transactions(private var amount: Double = 0.00,
                        private var payee: String? = null,
                        private var subcategory: String? = null,
                        private var cleared: Boolean = false,
                        private var memo: String? = null) {

    fun setAmount(newAmount: Double) {
        amount = newAmount
    }
    fun getAmount(): Double {
        return amount
    }

    fun setPayee(newPayee: String) {
        payee = newPayee
    }
    fun getPayee(): String? {
        return payee
    }

    fun setSubcategory(newSub: String) {
        subcategory = newSub
    }
    fun getSubcategory(): String? {
        return subcategory
    }

    fun setCleared(boo: Boolean) {
        cleared = boo
    }
    fun getCleared(): Boolean {
        return cleared
    }

    fun setMemo(newMemo: String) {
        memo = newMemo
    }
    fun getMemo(): String? {
        return memo
    }
}

