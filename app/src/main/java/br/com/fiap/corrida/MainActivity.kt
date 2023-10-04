package br.com.fiap.corrida

import RunningViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import br.com.fiap.corrida.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<RunningViewModel>()
    private var coroutine1: Job? = null
    private var coroutine2: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            coroutine1 = lifecycleScope.launch(Dispatchers.Main) {
                while (binding.progressBarHorse1.progress < 100) {
                    Log.d("DENTRO DO WHILE 1 ",binding.progressBarHorse1.progress.toString())
                    viewModel.calculateRunning(binding.progressBarHorse1.progress, 1)
                    delay(1500)
                }
            }

            coroutine2 = lifecycleScope.launch(Dispatchers.Main) {
                while (binding.progressBarHorse2.progress < 100) {
                    Log.d("DENTRO DO WHILE 2",binding.progressBarHorse2.progress.toString() )
                    viewModel.calculateRunning(binding.progressBarHorse2.progress, 2)
                    delay(1500)
                }
            }
        }

        binding.btnStop.setOnClickListener {
            coroutine1?.cancel()
            coroutine2?.cancel()
            binding.progressBarHorse1.progress = 0
            binding.progressBarHorse2.progress = 0
        }

        // Observar as atualizações da ViewModel para a barra de progresso 1
        viewModel.runningIsFinished1.observe(this, Observer { progress ->
            binding.progressBarHorse1.progress = progress
            if (progress >= 100) {
                binding.textWinner.text = "CAVALO AZUL VENCEDOR"
                coroutine1?.cancel()
                coroutine2?.cancel()
            }
        })

        // Observar as atualizações da ViewModel para a barra de progresso 2
        viewModel.runningIsFinished2.observe(this, Observer { progress ->
            binding.progressBarHorse2.progress = progress
            if (progress >= 100) {
                binding.textWinner.text = "CAVALO VERMELHO VENCEDOR"
                coroutine1?.cancel()
                coroutine2?.cancel()
            }
        })
    }

    private fun startRace() {
        coroutine1 = lifecycleScope.launch(Dispatchers.Main) {
            while (binding.progressBarHorse1.progress < 100) {
                Log.d("LOG CAVALO 1 ",binding.progressBarHorse1.progress.toString())
                viewModel.calculateRunning(binding.progressBarHorse1.progress, 1)
                delay(1500)
            }
        }

        coroutine2 = lifecycleScope.launch(Dispatchers.Main) {
            while (binding.progressBarHorse2.progress < 100) {
                Log.d("LOG CAVALO 2",binding.progressBarHorse2.progress.toString() )
                viewModel.calculateRunning(binding.progressBarHorse2.progress, 2)
                delay(1500)
            }
        }
    }
}
