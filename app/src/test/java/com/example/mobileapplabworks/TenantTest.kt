package com.example.mobileapplabworks

import org.junit.Assert.assertEquals
import org.junit.Test

class TenantTest {

    @Test
    fun testTenantSummary() {
        val tenant = Tenant("John Doe", "0712345678", "15000")
        val expected = "Tenant: John Doe\nPhone: 0712345678\nRent: KSh 15000"
        assertEquals(expected, tenant.summary())
    }
}
