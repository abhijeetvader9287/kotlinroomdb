package demo.kotlinroomdb.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.irontec.roomexample.adapters.ProviderAdapter
import demo.kotlinroomdb.R
import demo.kotlinroomdb.database.AppDatabase
import kotlinx.android.synthetic.main.activity_providers.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ProvidersActivity : AppCompatActivity() {

    private var mAdapter: ProviderAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_providers)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        mAdapter = ProviderAdapter(this@ProvidersActivity, mutableListOf())
        providers_list.adapter = mAdapter

        doAsync {

            val database = AppDatabase.getInstance(context = this@ProvidersActivity)
            val providers = database.providerDao().all

            uiThread {
                mAdapter!!.addAll(providers)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.empty, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
