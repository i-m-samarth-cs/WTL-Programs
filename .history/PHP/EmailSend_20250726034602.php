<?php
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require 'PHPMailer/src/PHPMailer.php';
require 'PHPMailer/src/SMTP.php';
require 'PHPMailer/src/Exception.php';

$mail = new PHPMailer(true);

try {
    // SMTP settings
    $mail->isSMTP();
    $mail->Host = 'smtp.gmail.com';              // SMTP server
    $mail->SMTPAuth = true;
    $mail->Username = 'samarthscoegmail@gmail.com';     // 🔸 Your Gmail address
    $mail->Password = 'Samarth2004@';       // 🔸 App password from Google
    $mail->SMTPSecure = 'tls';
    $mail->Port = 587;

    // Email settings
    $mail->setFrom('samarthscoegmail@gmail.com', 'Your Name');      // Sender
    $mail->addAddress('sh23samartht@example.com', 'Receiver');   // Receiver
    $mail->Subject = 'Test Email from PHPMailer';
    $mail->Body    = 'This is a test email sent from PHPMailer using Gmail SMTP.';

    $mail->send();
    echo '✅ Email has been sent successfully.';
} catch (Exception $e) {
    echo "❌ Email could not be sent. Error: {$mail->ErrorInfo}";
}
?>
