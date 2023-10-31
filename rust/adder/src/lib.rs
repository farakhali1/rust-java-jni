extern crate libc;
use jni::objects::JClass;
use jni::objects::JValue;
use jni::sys::jint;
use jni::JNIEnv;

// Warning Disabled
#[allow(unused_variables)]
#[allow(non_snake_case)]
#[no_mangle]
pub extern "system" fn Java_test_1rust_add_1numbers_1rust<'local>(
    java_jni_env: JNIEnv<'local>,
    java_class: JClass<'local>,
    number1: jint,
    number2: jint,
) -> jint {
    // call java callback from rust
    // let java_string = java_jni_env
    //     .new_string("rust")
    //     .expect("Failed to create Java string");
    // let jvalue_string = JValue::Object(java_string.into());

    // let _ = java_jni_env.call_static_method(
    //     java_class,
    //     "callback",
    //     "(Ljava/lang/String;)V",
    //     &[jvalue_string],
    // );

    // sum input numbers
    number1 + number2
}
