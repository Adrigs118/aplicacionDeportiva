package com.prueba.aplicaciondeportiva.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.prueba.aplicaciondeportiva.database.Dao.*
import com.prueba.aplicaciondeportiva.database.Entity.*
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GymDatabaseTest : TestCase() {

    //region variables para los test
    private lateinit var db : GymDatabase
    private lateinit var dao1: StrechtingDao
    private lateinit var dao2: DietDao
    private lateinit var dao3: BodyDao
    private lateinit var dao4: ConfigDao
    private lateinit var dao5: NotificationDao

    private val strechting = StrechtingEntity(100, "Test", "Description test",
        5, 15, 10.5F, "http:/test.test")
    private val diet = DietEntity("Test", "Description test", "testing")
    private val dietDay = DietDayEntity("monday", "Test", "test1",
        "","","","")
    private val body = BodyEntity(100, true, 20, 80.8F, 150, 21.34)
    private val config = ConfigEntity(100, false, true, "en")
    private val notification = NotificationEntity("100000test", "test", "description test")
    //endregion

    //region métodos comunes
    @Before
    public override fun setUp(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, GymDatabase::class.java).build()
        dao1 = db.strechtingDao()
        dao2 = db.dietDao()
        dao3 = db.bodyDao()
        dao4 = db.configDao()
        dao5 = db.notificationDao()
    }

    @After
    fun closeDb() {
        db.close()
    }
    //endregion

    //region Tests
    @Test
    fun writeAndReadGymDatabase_strecthting() = runBlocking {
        dao1.insert(strechting)
        val result = dao1.getById(100)
        assertThat(result, equalTo(strechting))
        result.series = 80
        dao1.update((result))
        val result_update = dao1.getById(100)
        assertThat(result_update, equalTo(result))
        dao1.delete(result)
        val result_delete = dao1.getById(100)
        assertNull(result_delete)
    }

    @Test
    fun writeAndReadGymDatabase_body() = runBlocking {
        dao3.insert(body)
        val result = dao3.getAll()
        assertThat(body, equalTo(result[0]))
        body.age = 1000
        dao3.update((body))
        val result_update = dao3.getAll()
        assertThat(result_update[0], equalTo(body))
        dao3.delete(body)
        val result_delete = dao3.getAll()
        assertThat(result_delete.size, equalTo(0))
    }

    @Test
    fun writeAndReadGymDatabase_settings() = runBlocking {
        dao4.insert(config)
        val result = dao4.get()
        assertThat(result, equalTo(config))
        config.language = "cat"
        dao4.update((result))
        val result_update = dao4.get()
        assertThat(result_update, equalTo(config))
    }

    @Test
    fun writeAndReadGymDatabase_notifications() = runBlocking {
        dao1.insert(strechting)
        val result = dao1.getById(100)
        assertThat(result, equalTo(strechting))
        result.series = 80
        dao1.update((result))
        val result_update = dao1.getById(100)
        assertThat(result_update, equalTo(result))
        dao1.delete(result)
        val result_delete = dao1.getById(100)
        assertNull(result_delete)
    }

    @Test
    fun writeAndReadGymDatabase_diet() = runBlocking {
        dao2.insert(diet)
        dao2.insertDay(dietDay)
        var result = dao2.getAll()
        assertThat(result.value?.get(0)?.diet, equalTo(diet))
        assertThat(result.value?.get(0)?.days?.get(0), equalTo(dietDay))
        diet.description = "new description"
        dietDay.breakfast = "new breakfast"
        dao2.update((diet))
        dao2.updateDay(dietDay)
        result = dao2.getAll()
        assertThat(result.value?.get(0)?.diet, equalTo(diet))
        assertThat(result.value?.get(0)?.days?.get(0), equalTo(dietDay))
        dao2.delete(diet)
        dao2.deleteDay(dietDay)
        result = dao2.getAll()
        assertNull(result.value)
    }

    //endregion


}