package com.github.rotstrom.ssh

import java.util.concurrent.TimeUnit

import net.schmizz.sshj.SSHClient
import net.schmizz.sshj.common.IOUtils
import net.schmizz.sshj.connection.channel.direct.Session

object Exec {
  def main(args: Array[String]) {
    val ssh = new SSHClient()

    ssh.addHostKeyVerifier(new NullHostKeyVerifier())
    ssh.connect("localhost")

    try {
      ssh.authPassword("alex", "12345")

      val session = ssh.startSession()
      try {
        exec("whoami", session)
        // another exec call to same session is not permitted
        // exec("whoami", session)
      } finally {
        session.close()
      }
    } finally {
      ssh.disconnect()
    }
  }

  def exec(cmd: String, session: Session): Unit = {
    val cmd = session.exec("whoami")
    println(IOUtils.readFully(cmd.getInputStream).toString.trim)
    cmd.join(5, TimeUnit.SECONDS)
    println(cmd.getExitStatus)
  }
}
