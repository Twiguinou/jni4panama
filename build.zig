const std = @import("std");

pub fn build(b: *std.Build) !void {
    const targetQueries = [_]std.Target.Query {
        .{ .cpu_arch = .x86_64, .os_tag = .linux },
        .{ .cpu_arch = .x86, .os_tag = .linux },
        .{ .cpu_arch = .aarch64, .os_tag = .linux },
        .{ .cpu_arch = .arm, .os_tag = .linux },
        .{ .cpu_arch = .loongarch64, .os_tag = .linux },
        .{ .cpu_arch = .mips64, .os_tag = .linux },
        .{ .cpu_arch = .mips64el, .os_tag = .linux },
        .{ .cpu_arch = .mips, .os_tag = .linux },
        .{ .cpu_arch = .mipsel, .os_tag = .linux },
        .{ .cpu_arch = .powerpc64, .os_tag = .linux },
        .{ .cpu_arch = .powerpc64le, .os_tag = .linux },
        .{ .cpu_arch = .powerpc, .os_tag = .linux },
        .{ .cpu_arch = .riscv64, .os_tag = .linux },
        .{ .cpu_arch = .riscv32, .os_tag = .linux },
        .{ .cpu_arch = .s390x, .os_tag = .linux },

        .{ .cpu_arch = .x86_64, .os_tag = .windows },
        .{ .cpu_arch = .x86, .os_tag = .windows },
        .{ .cpu_arch = .aarch64, .os_tag = .windows },

        .{ .cpu_arch = .x86_64, .os_tag = .macos },
        .{ .cpu_arch = .aarch64, .os_tag = .macos },

        .{ .cpu_arch = .x86_64, .os_tag = .freebsd },
        .{ .cpu_arch = .aarch64, .os_tag = .freebsd },
        .{ .cpu_arch = .arm, .os_tag = .freebsd },
        .{ .cpu_arch = .riscv64, .os_tag = .freebsd },
        .{ .cpu_arch = .powerpc64, .os_tag = .freebsd },
        .{ .cpu_arch = .powerpc64le, .os_tag = .freebsd },

        .{ .cpu_arch = .x86_64, .os_tag = .netbsd },
        .{ .cpu_arch = .aarch64, .os_tag = .netbsd },
        .{ .cpu_arch = .arm, .os_tag = .netbsd },
        .{ .cpu_arch = .powerpc, .os_tag = .netbsd },
        .{ .cpu_arch = .mips, .os_tag = .netbsd },
        .{ .cpu_arch = .mipsel, .os_tag = .netbsd }
    };

    const optimize = b.standardOptimizeOption(.{});
    const maybeJNIInclude = b.option(std.Build.LazyPath, "jniInclude", "jni.h, jawt.h and machine dependent headers location");

    for (targetQueries) |query| {
        const target = b.resolveTargetQuery(query);
        const arch_name = @tagName(target.query.cpu_arch.?);
        const os_name = @tagName(target.query.os_tag.?);

        const libj4p = b.addLibrary(.{
            .name = try std.fmt.allocPrint(b.allocator, "j4p-{s}-{s}", .{ arch_name, os_name }),
            .linkage = .dynamic,
            .root_module = b.createModule(.{
                .target = target,
                .optimize = optimize,
                .link_libc = true
            })
        });

        if (maybeJNIInclude) |jniInclude| {
            libj4p.addIncludePath(jniInclude);
            libj4p.addIncludePath(jniInclude.path(b, switch (target.result.os.tag) {
                .windows => "windows",
                else => "unix"
            }));
        }

        libj4p.addCSourceFiles(.{
            .root = b.path("src/main/c"),
            .files = &.{
                "j4p_jni.c",
                "j4p_awt.c"
            }
        });

        b.installArtifact(libj4p);
    }
}
