
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require 'vendor/autoload.php'; // If using Composer

$mail = new PHPMailer(true);

try {
    $mail->isSMTP();
    $mail->Host       = 'smtp.gmail.com';
    $mail->SMTPAuth   = true;
    $mail->Username   = 'samarthscoegmail@gmail.com';
    $mail->Password   = 'Samarth2004@'; // Use app password
    $mail->SMTPSecure = 'tls';
    $mail->Port       = 587;

    $mail->setFrom('samarthscoe@gmail.com', 'Mailer');
    $mail->addAddress('sh23samartht@example.com', 'Receiver Name');

    $mail->Subject = 'Here is the subject';
    $mail->Body    = 'This is the body of the message';

    $mail->send();
    echo 'Message has been sent';
} catch (Exception $e) {
    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
}
