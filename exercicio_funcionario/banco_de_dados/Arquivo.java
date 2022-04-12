package exercicio_funcionario.banco_de_dados;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Arquivo implements Repositorio {

    private String arquivo = null;

    Arquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public List<String> ler() {
        List<String> linhas = new ArrayList<String>();
        try {
            File file = new File(this.arquivo);
            Scanner entrada = new Scanner(file);
            while (entrada.hasNextLine()) {
                String linha = entrada.nextLine();
                linhas.add(linha);
            }
            entrada.close();
        } catch (Exception exception) {
            return null;
        }
        return linhas.size() > 0 ? linhas : null;
    }

    public List<String> ler(String termo) {
        try {
            File arquivo = new File(this.arquivo);
            if(!arquivo.exists()) {
                return null;
            }   

            Scanner entrada = new Scanner(arquivo);
            List<String> linhas = new ArrayList<String>();

            while (entrada.hasNextLine()) {
                String linhaAtual = entrada.nextLine();
                if (linhaAtual.contains(termo)) {
                    linhas.add(linhaAtual);
                    break;
                }
            }
            entrada.close();

            return linhas.size() > 0 ? linhas : null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean escrever(String dados) {
        try {
            File arquivo = new File(this.arquivo);
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter escritor = new FileWriter(this.arquivo, true);
            if (arquivo.length() == 0) {
                escritor.write("1," + dados);
            } else {
                String linha = null, ultimaLinha = null;
                BufferedReader em = new BufferedReader(new FileReader(this.arquivo));
                while ((linha = em.readLine()) != null) {
                    if (linha != null) {
                        ultimaLinha = linha;
                    }
                }
                em.close();
                String[] linhaSeparada = ultimaLinha.split(",");
                int codigo = Integer.parseInt(linhaSeparada[0]);
                codigo++;
                escritor.write(System.lineSeparator() + codigo + "," + dados);
            }
            escritor.close();
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    public boolean editar (String codigo, String novosDados) {
        try {
            File arquivo = new File(this.arquivo);
            if(!arquivo.exists()) {
                return false;
            }   

            Scanner entrada = new Scanner(arquivo);
            List<String> linhas = new ArrayList<String>();
            Boolean codigoEncontrado = false;    

            while (entrada.hasNextLine()) {
                String linhaAtual = entrada.nextLine();
                if (linhaAtual.contains(codigo)) {
                    codigoEncontrado = true;
                    linhas.add(codigo + "," + novosDados);
                } else {
                    linhas.add(linhaAtual);
                }
            }

            entrada.close();

            if (!codigoEncontrado) {
                return false;
            }

            FileWriter escritorDeArquivo = new FileWriter(this.arquivo);

            for (int contador = 0; contador < linhas.size(); contador++) {
                if (contador == linhas.size() - 1) {
                    escritorDeArquivo.write(linhas.get(contador));
                } else {
                    escritorDeArquivo.write(linhas.get(contador) + System.lineSeparator());
                }
            }
            escritorDeArquivo.close();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean excluir (String codigo) {
        try {
            File arquivo = new File(this.arquivo);
            if(!arquivo.exists()) {
                return false;
            }   

            Scanner entrada = new Scanner(arquivo);
            List<String> linhas = new ArrayList<String>();
            Boolean codigoEncontrado = false;    

            while (entrada.hasNextLine()) {
                String linhaAtual = entrada.nextLine();
                if (!linhaAtual.contains(codigo)) {
                    linhas.add(linhaAtual);
                } else {
                    codigoEncontrado = true;
                }
            }

            entrada.close();

            if (!codigoEncontrado) {
                return false;
            }

            FileWriter escritorDeArquivo = new FileWriter(this.arquivo);
            for (int contador = 0; contador < linhas.size(); contador++) {
                if (contador == linhas.size() - 1) {
                    escritorDeArquivo.write(linhas.get(contador));
                } else {
                    escritorDeArquivo.write(linhas.get(contador) + System.lineSeparator());
                }
            }
            escritorDeArquivo.close();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
