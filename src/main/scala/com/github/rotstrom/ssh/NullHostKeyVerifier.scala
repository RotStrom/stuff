package com.github.rotstrom.ssh

import java.security.PublicKey

import net.schmizz.sshj.transport.verification.HostKeyVerifier

/**
 * @author Alexandr Kovalev <a.kovalev@solarsecurity.ru>
 */
class NullHostKeyVerifier extends HostKeyVerifier {
  def verify(arg0: String, arg1: Int, arg2: PublicKey): Boolean = true
}
