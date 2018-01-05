package com.restrictions.gateways

import com.restrictions.entities.Restriction

class InMemoryRestrictionsGateway: RestrictionGateway {
    private var restrictionsMap: HashMap<String, ArrayList<Restriction>> = hashMapOf("3030" to arrayListOf(Restriction("5050"), Restriction("4040")) )

    override fun getRestriction(code: String): Restriction {
        return Restriction(code)
    }

    override fun getProductRestrictions(productCode: String): List<Restriction> {
        return restrictionsMap[productCode]?: arrayListOf()
    }

    override fun addRestrictionToProduct(productCode: String, restrictionCode: String): Boolean {
        if(restrictionsMap.contains(productCode)){
            restrictionsMap[productCode]?.add(Restriction(restrictionCode))
        }else{
            restrictionsMap.put(productCode, arrayListOf(Restriction(restrictionCode)))
        }

        return true
    }
}